// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: companies.proto

package io.grpc.grpcDemo1;

public interface CompanyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:companies.Company)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * The name of the company
   * </pre>
   *
   * <code>.companies.Name name = 1;</code>
   */
  boolean hasName();
  /**
   * <pre>
   * The name of the company
   * </pre>
   *
   * <code>.companies.Name name = 1;</code>
   */
  io.grpc.grpcDemo1.Name getName();
  /**
   * <pre>
   * The name of the company
   * </pre>
   *
   * <code>.companies.Name name = 1;</code>
   */
  io.grpc.grpcDemo1.NameOrBuilder getNameOrBuilder();

  /**
   * <pre>
   * The year in which the company was founded.
   * </pre>
   *
   * <code>.companies.FoundingYear foundingYear = 2;</code>
   */
  boolean hasFoundingYear();
  /**
   * <pre>
   * The year in which the company was founded.
   * </pre>
   *
   * <code>.companies.FoundingYear foundingYear = 2;</code>
   */
  io.grpc.grpcDemo1.FoundingYear getFoundingYear();
  /**
   * <pre>
   * The year in which the company was founded.
   * </pre>
   *
   * <code>.companies.FoundingYear foundingYear = 2;</code>
   */
  io.grpc.grpcDemo1.FoundingYearOrBuilder getFoundingYearOrBuilder();

  /**
   * <pre>
   * The current market value of the company. 
   * For simple, int32 is used instead of float
   * </pre>
   *
   * <code>int32 marketValue = 3;</code>
   */
  int getMarketValue();
}
