package com.example.elk.swagger.user.model;

import java.net.URI;
import java.util.Objects;
import com.example.elk.swagger.user.model.RoleResponse;
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
 * Roles response
 */

@Schema(name = "RolesResponse", description = "Roles response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class RolesResponse   {

  @JsonProperty("size")
  private Integer size;

  @JsonProperty("roles")
  @Valid
  private List<RoleResponse> roles = null;

  public RolesResponse size(Integer size) {
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

  public RolesResponse roles(List<RoleResponse> roles) {
    this.roles = roles;
    return this;
  }

  public RolesResponse addRolesItem(RoleResponse rolesItem) {
    if (this.roles == null) {
      this.roles = new ArrayList<>();
    }
    this.roles.add(rolesItem);
    return this;
  }

  /**
   * Get roles
   * @return roles
  */
  @Valid 
  @Schema(name = "roles", required = false)
  public List<RoleResponse> getRoles() {
    return roles;
  }

  public void setRoles(List<RoleResponse> roles) {
    this.roles = roles;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RolesResponse rolesResponse = (RolesResponse) o;
    return Objects.equals(this.size, rolesResponse.size) &&
        Objects.equals(this.roles, rolesResponse.roles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(size, roles);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RolesResponse {\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
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

