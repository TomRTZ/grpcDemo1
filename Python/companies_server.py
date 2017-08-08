# This companies_server.py file utilizes the generated .py files by grpc tools to run a server
# The grpc tools generate companies_pb2.py and companies_pb2_grpc.py according to companies.proto
# companies_pb2.py contains classes for the messages defined in companies.proto
# companies_pb2_grpc.py contains client stub and servicer classes for the services defined in companies.proto
# A function from companies_resources.py is also called in this file to load some data
# This file is part of a grpc demo
# In order to run this program, some grpc modules in python should be firstly installed,
# please refer to the grpc tutorials on http://www.grpc.io/docs/quickstart/python.html


"""The Python implementation of the gRPC companies information server."""

from concurrent import futures
import time

import grpc

import companies_pb2
import companies_pb2_grpc
import companies_resources

_ONE_DAY_IN_SECONDS = 60 * 60 * 24


def get_founding_year(companies_db, input_name):
  """Returns the founding year of the given company name."""
  for company in companies_db:
    if company.name.name == input_name.name:
      return company.foundingYear
  #for simplicity, a default year 2900 is returned if no matched company is found
  return companies_pb2.FoundingYear(year=2900)


class CompaniesServicer(companies_pb2_grpc.CompaniesServicer):
  """Provides methods that implement functionality of companies information server."""

  def __init__(self):
    self.db = companies_resources.read_companies_database()

  def GetFoundingYear(self, request, context):
    founding_year = get_founding_year(self.db, request)
    return founding_year

  def ListCompanies(self, request, context):
    for company in self.db:
      if company.foundingYear == request:
        yield company.name

  def CalcAverageAge(self, request_iterator, context):
    current_year = 2017
    total_age = 0
    company_count = 0

    for company_name in request_iterator:
      for company in self.db:
        if company.name.name == company_name.name:
          total_age += (current_year - company.foundingYear.year)
          company_count += 1
          break

    average_age = int(total_age / company_count)
    return companies_pb2.AverageAge(age=average_age)  

  def GetCompanyInformation(self, request_iterator, context):
    for company_name in request_iterator:
      found = False
      for company in self.db:
        if company.name == company_name:
          yield company
          found = True
          break
      if not found:
        yield companies_pb2.Company(
            name = companies_pb2.Name(name="not found"),
            foundingYear = companies_pb2.FoundingYear(year=2900),
            marketValue = 0)


def serve():
  server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
  companies_pb2_grpc.add_CompaniesServicer_to_server(
      CompaniesServicer(), server)
  server.add_insecure_port('[::]:50051')
  server.start()
  print("Server has started, listenning in port 50051")
  try:
    while True:
      time.sleep(_ONE_DAY_IN_SECONDS)
  except KeyboardInterrupt:
    server.stop(0)
    print("Server has stopped")

if __name__ == '__main__':
  serve()
