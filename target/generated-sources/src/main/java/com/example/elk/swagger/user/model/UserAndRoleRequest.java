package com.example.elk.swagger.user.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * User and role response
 */

@Schema(name = "UserAndRoleRequest", description = "User and role response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class UserAndRoleRequest   {

  @JsonProperty("username")
  private String username;

  @JsonProperty("role")
  private String role;

  public UserAndRoleRequest username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Username of the user
   * @return username
  */
  @Size(min = 5, max = 256) 
  @Schema(name = "username", example = "ricardo123", description = "Username of the user", required = false)
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public UserAndRoleRequest role(String role) {
    this.role = role;
    return this;
  }

  /**
   * Role of the user
   * @return role
  */
  @Size(min = 2, max = 20) 
  @Schema(name = "role", example = "ADMIN", description = "Role of the user", required = false)
  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserAndRoleRequest userAndRoleRequest = (UserAndRoleRequest) o;
    return Objects.equals(this.username, userAndRoleRequest.username) &&
        Objects.equals(this.role, userAndRoleRequest.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, role);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserAndRoleRequest {\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
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

