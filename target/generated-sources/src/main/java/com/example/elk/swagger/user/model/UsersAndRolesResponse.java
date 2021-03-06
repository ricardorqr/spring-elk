package com.example.elk.swagger.user.model;

import java.net.URI;
import java.util.Objects;
import com.example.elk.swagger.user.model.UserAndRolesResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Users response
 */

@Schema(name = "UsersAndRolesResponse", description = "Users response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class UsersAndRolesResponse   {

  @JsonProperty("size")
  private Integer size;

  @JsonProperty("users")
  @Valid
  private List<UserAndRolesResponse> users = null;

  public UsersAndRolesResponse size(Integer size) {
    this.size = size;
    return this;
  }

  /**
   * Size of the list
   * @return size
  */
  @NotNull 
  @Schema(name = "size", example = "2", description = "Size of the list", required = true)
  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public UsersAndRolesResponse users(List<UserAndRolesResponse> users) {
    this.users = users;
    return this;
  }

  public UsersAndRolesResponse addUsersItem(UserAndRolesResponse usersItem) {
    if (this.users == null) {
      this.users = new ArrayList<>();
    }
    this.users.add(usersItem);
    return this;
  }

  /**
   * Get users
   * @return users
  */
  @Valid 
  @Schema(name = "users", required = false)
  public List<UserAndRolesResponse> getUsers() {
    return users;
  }

  public void setUsers(List<UserAndRolesResponse> users) {
    this.users = users;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UsersAndRolesResponse usersAndRolesResponse = (UsersAndRolesResponse) o;
    return Objects.equals(this.size, usersAndRolesResponse.size) &&
        Objects.equals(this.users, usersAndRolesResponse.users);
  }

  @Override
  public int hashCode() {
    return Objects.hash(size, users);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UsersAndRolesResponse {\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    users: ").append(toIndentedString(users)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

