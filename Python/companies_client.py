# This companies_client.py file utilizes the generated .py files by grpc tools to run a client
# The grpc tools generate companies_pb2.py and companies_pb2_grpc.py according to companies.proto
# companies_pb2.py contains classes for the messages defined in companies.proto
# companies_pb2_grpc.py contains client stub and servicer classes for the services defined in companies.proto
# This file is part of a grpc demo
# In order to run this program, some grpc modules in python should be firstly installed,
# please refer to the grpc tutorials on http://www.grpc.io/docs/quickstart/python.html


"""The Python implementation of the gRPC companies information client."""

#from __future__ import print_function
from sys import getsizeof

import random
import time

import grpc

import companies_pb2
import companies_pb2_grpc


def print_company_names_by_year(year, company_names):
  if getsizeof(company_names) == 0:
    print("No company in the database was founded in the year of %d" % year.year)
  else:
    print("The companies founded in the year %d is listed below: " % year.year)
    for name in company_names:
      print(name.name)


def print_founding_year(name, year):
  if year.year == 2900:
    print("No such a company: %s" % name.name)
  else:
    print("Company %s was founded in the year of %d" % (name.name, year.year))


def guide_get_founding_year(stub):
  company_name_1 = companies_pb2.Name(name="ABC Estate")
  company_name_2 = companies_pb2.Name(name="ABC Something")  #no such a company in the server's database
  
  print("Inquire the founding year of company %s" % company_name_1.name)
  founding_year = stub.GetFoundingYear(company_name_1)
  print_founding_year(company_name_1, founding_year)
  print("Inquire the founding year of company %s" % company_name_2.name)
  founding_year = stub.GetFoundingYear(company_name_2)
  print_founding_year(company_name_2, founding_year)
  print("")
  

def guide_list_companies(stub):
  year = companies_pb2.FoundingYear(year=1998)
  print("Looking for companies founded in the year %d" % year.year)

  companies = stub.ListCompanies(year)  
  print_company_names_by_year(year, companies)
  print("")


def generate_some_names_1():
  name_list = []
  name = companies_pb2.Name(name="ABC Telecom")
  name_list.append(name)
  name = companies_pb2.Name(name="DEF Telecom")
  name_list.append(name)
  name = companies_pb2.Name(name="GHI Telecom")
  name_list.append(name)
  name = companies_pb2.Name(name="JKL Telecom")
  name_list.append(name)
  name = companies_pb2.Name(name="MNO Telecom")
  name_list.append(name)
  
  print("the company names sent to the server are: ")
  for name in name_list:
    print(name.name)
    yield name


def guide_calculate_average_age(stub):
  print("Send some company names to the server and get their average existing years")
  company_names = generate_some_names_1()
  average_age = stub.CalcAverageAge(company_names)
  print("The average existing years of those companies are %d years " % average_age.age)
  print("")


def generate_some_names_2():
  company_names = [
      companies_pb2.Name(name="ABC Garment"),
      companies_pb2.Name(name="AAA Garment"),
      companies_pb2.Name(name="DEF Garment"),
      companies_pb2.Name(name="JKL Motors"),
      companies_pb2.Name(name="MNO Motor"),
  ]
  for name in company_names:
    print("Sending company name %s" % name.name)
    yield name
    time.sleep(random.uniform(0.5, 1.0))


def guide_get_company_information(stub):
  responses = stub.GetCompanyInformation(generate_some_names_2())  #asynchronous mode
  for response in responses:
    print("Received company information: name is %s, founding year is %d, market value is %d" % (response.name.name, response.foundingYear.year, response.marketValue))
  print("")
	

def run():
  channel = grpc.insecure_channel('localhost:50051')
  stub = companies_pb2_grpc.CompaniesStub(channel)
  print("-------------- GetFoundingYear --------------")
  guide_get_founding_year(stub)
  print("-------------- ListCompanies --------------")
  guide_list_companies(stub)
  print("-------------- CalcAverageAge --------------")
  guide_calculate_average_age(stub)
  print("-------------- GetCompanyInformation --------------")
  guide_get_company_information(stub)


if __name__ == '__main__':
  run()
