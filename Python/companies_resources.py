# This .py file contains just one function definition: read_companies_database()
# The function reads the companies_db.json file in the same directory as this .py file
# The contents of companies_db.json file is read out and save in a python sequence
# Then the sequence is returned
# This function is called by companies_server.py in the same directory as this .py file
# It is part of a grpc demo

"""Common resources used in the gRPC companies demo."""

import json

import companies_pb2


def read_companies_database():
  """Reads the companies database.

  Returns:
    The full contents of the companies database as a sequence of
      companies_pb2.Company.
  """
  company_list = []
  with open("companies_db.json") as companies_db_file:
    for item in json.load(companies_db_file):
      company = companies_pb2.Company(
          name=companies_pb2.Name(name=item["name"]),
          foundingYear=companies_pb2.FoundingYear(year=item["foundingYear"]),
		  marketValue=item["marketValue"])		  
      company_list.append(company)
  return company_list

  