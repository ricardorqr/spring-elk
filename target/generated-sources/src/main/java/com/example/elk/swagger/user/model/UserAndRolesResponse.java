package com.example.elk.swagger.user.model;

import java.net.URI;
import java.util.Objects;
import com.example.elk.swagger.user.model.RoleResponse;
import com.example.elk.swagger.user.model.UserDTO;
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
 * User response
 */

@Schema(name = "UserAndRolesResponse", description = "User response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class UserAndRolesResponse   {

  @JsonProperty("roles")
  @Valid
  private List<RoleResponse> roles = null;

  @JsonProperty("name")
  private String name;

  @JsonProperty("username")
  private String username;

  @JsonProperty("password")
  private String password;

  public UserAndRolesResponse roles(List<RoleResponse> roles) {
    this.roles = roles;
    return this;
  }

  public UserAndRolesResponse addRolesItem(RoleResponse rolesItem) {
    if (this.roles == null) {
      this.roles = new ArrayList<>();
    }
    this.roles.add(rolesItem);
    return this;
  }

  /**
   * Roles of the user
   * @return roles
  */
  @Valid 
  @Schema(name = "roles", description = "Roles of the user", required = false)
  public List<RoleResponse> getRoles() {
    return roles;
  }

  public void setRoles(List<RoleResponse> roles) {
    this.roles = roles;
  }

  public UserAndRolesResponse name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of ther user
   * @return name
  */
  @NotNull @Size(min = 5, max = 256) 
  @Schema(name = "name", example = "Ricardo Ribeiro", description = "Name of ther user", required = true)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UserAndRolesResponse username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Login of ther user
   * @return username
  */
  @NotNull @Size(min = 5, max = 256) 
  @Schema(name = "username", example = "ribeirorqr", description = "Login of ther user", required = true)
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public UserAndRolesResponse password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Password of ther user
   * @return password
  */
  @NotNull @Size(min = 5, max = 256) 
  @Schema(name = "password", example = "ricardo123", description = "Password of ther user", required = true)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserAndRolesResponse userAndRolesResponse = (UserAndRolesResponse) o;
    return Objects.equals(this.roles, userAndRolesResponse.roles) &&
        Objects.equals(this.name, userAndRolesResponse.name) &&
        Objects.equals(this.username, userAndRolesResponse.username) &&
        Objects.equals(this.password, userAndRolesResponse.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(roles, name, username, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserAndRolesResponse {\n");
    sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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

