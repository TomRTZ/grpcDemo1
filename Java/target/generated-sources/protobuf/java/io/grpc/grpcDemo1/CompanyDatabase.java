// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: companies.proto

package io.grpc.grpcDemo1;

/**
 * <pre>
 * Not used in the RPC.  Instead, this is here for the form serialized to disk.
 * </pre>
 *
 * Protobuf type {@code companies.CompanyDatabase}
 */
public  final class CompanyDatabase extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:companies.CompanyDatabase)
    CompanyDatabaseOrBuilder {
  // Use CompanyDatabase.newBuilder() to construct.
  private CompanyDatabase(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CompanyDatabase() {
    company_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private CompanyDatabase(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              company_ = new java.util.ArrayList<io.grpc.grpcDemo1.Company>();
              mutable_bitField0_ |= 0x00000001;
            }
            company_.add(
                input.readMessage(io.grpc.grpcDemo1.Company.parser(), extensionRegistry));
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        company_ = java.util.Collections.unmodifiableList(company_);
      }
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.grpc.grpcDemo1.CompaniesProto.internal_static_companies_CompanyDatabase_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.grpc.grpcDemo1.CompaniesProto.internal_static_companies_CompanyDatabase_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.grpc.grpcDemo1.CompanyDatabase.class, io.grpc.grpcDemo1.CompanyDatabase.Builder.class);
  }

  public static final int COMPANY_FIELD_NUMBER = 1;
  private java.util.List<io.grpc.grpcDemo1.Company> company_;
  /**
   * <code>repeated .companies.Company company = 1;</code>
   */
  public java.util.List<io.grpc.grpcDemo1.Company> getCompanyList() {
    return company_;
  }
  /**
   * <code>repeated .companies.Company company = 1;</code>
   */
  public java.util.List<? extends io.grpc.grpcDemo1.CompanyOrBuilder> 
      getCompanyOrBuilderList() {
    return company_;
  }
  /**
   * <code>repeated .companies.Company company = 1;</code>
   */
  public int getCompanyCount() {
    return company_.size();
  }
  /**
   * <code>repeated .companies.Company company = 1;</code>
   */
  public io.grpc.grpcDemo1.Company getCompany(int index) {
    return company_.get(index);
  }
  /**
   * <code>repeated .companies.Company company = 1;</code>
   */
  public io.grpc.grpcDemo1.CompanyOrBuilder getCompanyOrBuilder(
      int index) {
    return company_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < company_.size(); i++) {
      output.writeMessage(1, company_.get(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < company_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, company_.get(i));
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof io.grpc.grpcDemo1.CompanyDatabase)) {
      return super.equals(obj);
    }
    io.grpc.grpcDemo1.CompanyDatabase other = (io.grpc.grpcDemo1.CompanyDatabase) obj;

    boolean result = true;
    result = result && getCompanyList()
        .equals(other.getCompanyList());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getCompanyCount() > 0) {
      hash = (37 * hash) + COMPANY_FIELD_NUMBER;
      hash = (53 * hash) + getCompanyList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.grpc.grpcDemo1.CompanyDatabase parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.grpcDemo1.CompanyDatabase parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.grpcDemo1.CompanyDatabase parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.grpcDemo1.CompanyDatabase parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.grpcDemo1.CompanyDatabase parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.grpcDemo1.CompanyDatabase parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.grpcDemo1.CompanyDatabase parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.grpc.grpcDemo1.CompanyDatabase parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.grpc.grpcDemo1.CompanyDatabase parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.grpc.grpcDemo1.CompanyDatabase parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.grpc.grpcDemo1.CompanyDatabase parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.grpc.grpcDemo1.CompanyDatabase parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(io.grpc.grpcDemo1.CompanyDatabase prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * Not used in the RPC.  Instead, this is here for the form serialized to disk.
   * </pre>
   *
   * Protobuf type {@code companies.CompanyDatabase}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:companies.CompanyDatabase)
      io.grpc.grpcDemo1.CompanyDatabaseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.grpc.grpcDemo1.CompaniesProto.internal_static_companies_CompanyDatabase_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.grpc.grpcDemo1.CompaniesProto.internal_static_companies_CompanyDatabase_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.grpc.grpcDemo1.CompanyDatabase.class, io.grpc.grpcDemo1.CompanyDatabase.Builder.class);
    }

    // Construct using io.grpc.grpcDemo1.CompanyDatabase.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getCompanyFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      if (companyBuilder_ == null) {
        company_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        companyBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.grpc.grpcDemo1.CompaniesProto.internal_static_companies_CompanyDatabase_descriptor;
    }

    public io.grpc.grpcDemo1.CompanyDatabase getDefaultInstanceForType() {
      return io.grpc.grpcDemo1.CompanyDatabase.getDefaultInstance();
    }

    public io.grpc.grpcDemo1.CompanyDatabase build() {
      io.grpc.grpcDemo1.CompanyDatabase result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public io.grpc.grpcDemo1.CompanyDatabase buildPartial() {
      io.grpc.grpcDemo1.CompanyDatabase result = new io.grpc.grpcDemo1.CompanyDatabase(this);
      int from_bitField0_ = bitField0_;
      if (companyBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          company_ = java.util.Collections.unmodifiableList(company_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.company_ = company_;
      } else {
        result.company_ = companyBuilder_.build();
      }
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof io.grpc.grpcDemo1.CompanyDatabase) {
        return mergeFrom((io.grpc.grpcDemo1.CompanyDatabase)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.grpc.grpcDemo1.CompanyDatabase other) {
      if (other == io.grpc.grpcDemo1.CompanyDatabase.getDefaultInstance()) return this;
      if (companyBuilder_ == null) {
        if (!other.company_.isEmpty()) {
          if (company_.isEmpty()) {
            company_ = other.company_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureCompanyIsMutable();
            company_.addAll(other.company_);
          }
          onChanged();
        }
      } else {
        if (!other.company_.isEmpty()) {
          if (companyBuilder_.isEmpty()) {
            companyBuilder_.dispose();
            companyBuilder_ = null;
            company_ = other.company_;
            bitField0_ = (bitField0_ & ~0x00000001);
            companyBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getCompanyFieldBuilder() : null;
          } else {
            companyBuilder_.addAllMessages(other.company_);
          }
        }
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      io.grpc.grpcDemo1.CompanyDatabase parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.grpc.grpcDemo1.CompanyDatabase) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<io.grpc.grpcDemo1.Company> company_ =
      java.util.Collections.emptyList();
    private void ensureCompanyIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        company_ = new java.util.ArrayList<io.grpc.grpcDemo1.Company>(company_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        io.grpc.grpcDemo1.Company, io.grpc.grpcDemo1.Company.Builder, io.grpc.grpcDemo1.CompanyOrBuilder> companyBuilder_;

    /**
     * <code>repeated .companies.Company company = 1;</code>
     */
    public java.util.List<io.grpc.grpcDemo1.Company> getCompanyList() {
      if (companyBuilder_ == null) {
        return java.util.Collections.unmodifiableList(company_);
      } else {
        return companyBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .companies.Company company = 1;</code>
     */
    public int getCompanyCount() {
      if (companyBuilder_ == null) {
        return company_.size();
      } else {
        return companyBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .companies.Company company = 1;</code>
     */
    public io.grpc.grpcDemo1.Company getCompany(int index) {
      if (companyBuilder_ == null) {
        return company_.get(index);
      } else {
        return companyBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .companies.Company company = 1;</code>
     */
    public Builder setCompany(
        int index, io.grpc.grpcDemo1.Company value) {
      if (companyBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCompanyIsMutable();
        company_.set(index, value);
        onChanged();
      } else {
        companyBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .companies.Company company = 1;</code>
     */
    public Builder setCompany(
        int index, io.grpc.grpcDemo1.Company.Builder builderForValue) {
      if (companyBuilder_ == null) {
        ensureCompanyIsMutable();
        company_.set(index, builderForValue.build());
        onChanged();
      } else {
        companyBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .companies.Company company = 1;</code>
     */
    public Builder addCompany(io.grpc.grpcDemo1.Company value) {
      if (companyBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCompanyIsMutable();
        company_.add(value);
        onChanged();
      } else {
        companyBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .companies.Company company = 1;</code>
     */
    public Builder addCompany(
        int index, io.grpc.grpcDemo1.Company value) {
      if (companyBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCompanyIsMutable();
        company_.add(index, value);
        onChanged();
      } else {
        companyBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .companies.Company company = 1;</code>
     */
    public Builder addCompany(
        io.grpc.grpcDemo1.Company.Builder builderForValue) {
      if (companyBuilder_ == null) {
        ensureCompanyIsMutable();
        company_.add(builderForValue.build());
        onChanged();
      } else {
        companyBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .companies.Company company = 1;</code>
     */
    public Builder addCompany(
        int index, io.grpc.grpcDemo1.Company.Builder builderForValue) {
      if (companyBuilder_ == null) {
        ensureCompanyIsMutable();
        company_.add(index, builderForValue.build());
        onChanged();
      } else {
        companyBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .companies.Company company = 1;</code>
     */
    public Builder addAllCompany(
        java.lang.Iterable<? extends io.grpc.grpcDemo1.Company> values) {
      if (companyBuilder_ == null) {
        ensureCompanyIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, company_);
        onChanged();
      } else {
        companyBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .companies.Company company = 1;</code>
     */
    public Builder clearCompany() {
      if (companyBuilder_ == null) {
        company_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        companyBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .companies.Company company = 1;</code>
     */
    public Builder removeCompany(int index) {
      if (companyBuilder_ == null) {
        ensureCompanyIsMutable();
        company_.remove(index);
        onChanged();
      } else {
        companyBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .companies.Company company = 1;</code>
     */
    public io.grpc.grpcDemo1.Company.Builder getCompanyBuilder(
        int index) {
      return getCompanyFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .companies.Company company = 1;</code>
     */
    public io.grpc.grpcDemo1.CompanyOrBuilder getCompanyOrBuilder(
        int index) {
      if (companyBuilder_ == null) {
        return company_.get(index);  } else {
        return companyBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .companies.Company company = 1;</code>
     */
    public java.util.List<? extends io.grpc.grpcDemo1.CompanyOrBuilder> 
         getCompanyOrBuilderList() {
      if (companyBuilder_ != null) {
        return companyBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(company_);
      }
    }
    /**
     * <code>repeated .companies.Company company = 1;</code>
     */
    public io.grpc.grpcDemo1.Company.Builder addCompanyBuilder() {
      return getCompanyFieldBuilder().addBuilder(
          io.grpc.grpcDemo1.Company.getDefaultInstance());
    }
    /**
     * <code>repeated .companies.Company company = 1;</code>
     */
    public io.grpc.grpcDemo1.Company.Builder addCompanyBuilder(
        int index) {
      return getCompanyFieldBuilder().addBuilder(
          index, io.grpc.grpcDemo1.Company.getDefaultInstance());
    }
    /**
     * <code>repeated .companies.Company company = 1;</code>
     */
    public java.util.List<io.grpc.grpcDemo1.Company.Builder> 
         getCompanyBuilderList() {
      return getCompanyFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        io.grpc.grpcDemo1.Company, io.grpc.grpcDemo1.Company.Builder, io.grpc.grpcDemo1.CompanyOrBuilder> 
        getCompanyFieldBuilder() {
      if (companyBuilder_ == null) {
        companyBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            io.grpc.grpcDemo1.Company, io.grpc.grpcDemo1.Company.Builder, io.grpc.grpcDemo1.CompanyOrBuilder>(
                company_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        company_ = null;
      }
      return companyBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:companies.CompanyDatabase)
  }

  // @@protoc_insertion_point(class_scope:companies.CompanyDatabase)
  private static final io.grpc.grpcDemo1.CompanyDatabase DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.grpc.grpcDemo1.CompanyDatabase();
  }

  public static io.grpc.grpcDemo1.CompanyDatabase getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CompanyDatabase>
      PARSER = new com.google.protobuf.AbstractParser<CompanyDatabase>() {
    public CompanyDatabase parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new CompanyDatabase(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<CompanyDatabase> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CompanyDatabase> getParserForType() {
    return PARSER;
  }

  public io.grpc.grpcDemo1.CompanyDatabase getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

