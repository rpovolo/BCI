package com.bci.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;
import javax.annotation.Generated;
import javax.validation.Valid;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * The User model response
 */

@Schema(name = "UserResponse", description = "The User model response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-22T17:22:42.292056350-03:00[America/Argentina/Mendoza]")
public class UserResponse {

  @JsonProperty("id")
  private String id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("email")
  private String email;

  @JsonProperty("password")
  private String password;

  @JsonProperty("phones")
  @Valid
  private List<Phone> phones = null;

  @JsonProperty("created")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime created;

  @JsonProperty("modified")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime modified;

  @JsonProperty("last_login")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime lastLogin;

  @JsonProperty("token")
  private String token;

  @JsonProperty("inactive")
  private Boolean inactive;

  public UserResponse id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  @Valid
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public UserResponse name(String name) {
    this.name = name;
    return this;
  }

  /**
   * A string attribute representing the name of a user or entity
   * @return name
   */

  @Schema(name = "name", description = "A string attribute representing the name of a user or entity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UserResponse email(String email) {
    this.email = email;
    return this;
  }

  /**
   * A string attribute storing the email address of a user.
   * @return email
   */

  @Schema(name = "email", description = "A string attribute storing the email address of a user.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserResponse password(String password) {
    this.password = password;
    return this;
  }

  /**
   * A string attribute representing the password associated with a user account. This field stores confidential information used for authentication and access control purposes
   * @return password
   */

  @Schema(name = "password", description = "A string attribute representing the password associated with a user account. This field stores confidential information used for authentication and access control purposes ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UserResponse phones(List<Phone> phones) {
    this.phones = phones;
    return this;
  }

  public UserResponse addPhonesItem(Phone phonesItem) {
    if (this.phones == null) {
      this.phones = new ArrayList<>();
    }
    this.phones.add(phonesItem);
    return this;
  }

  /**
   * Get phones
   * @return phones
   */
  @Valid
  @Schema(name = "phones", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public List<Phone> getPhones() {
    return phones;
  }

  public void setPhones(List<Phone> phones) {
    this.phones = phones;
  }

  public UserResponse created(OffsetDateTime created) {
    this.created = created;
    return this;
  }

  /**
   * Get created
   * @return created
   */
  @Valid
  @Schema(name = "created", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public OffsetDateTime getCreated() {
    return created;
  }

  public void setCreated(OffsetDateTime created) {
    this.created = created;
  }

  public UserResponse modified(OffsetDateTime modified) {
    this.modified = modified;
    return this;
  }

  /**
   * Get modified
   * @return modified
   */
  @Valid
  @Schema(name = "modified", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public OffsetDateTime getModified() {
    return modified;
  }

  public void setModified(OffsetDateTime modified) {
    this.modified = modified;
  }

  public UserResponse lastLogin(OffsetDateTime lastLogin) {
    this.lastLogin = lastLogin;
    return this;
  }

  /**
   * Get lastLogin
   * @return lastLogin
   */
  @Valid
  @Schema(name = "last_login", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public OffsetDateTime getLastLogin() {
    return lastLogin;
  }

  public void setLastLogin(OffsetDateTime lastLogin) {
    this.lastLogin = lastLogin;
  }

  public UserResponse token(String token) {
    this.token = token;
    return this;
  }

  /**
   * Get token
   * @return token
   */

  @Schema(name = "token", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public UserResponse inactive(Boolean inactive) {
    this.inactive = inactive;
    return this;
  }

  /**
   * Get inactive
   * @return inactive
   */

  @Schema(name = "inactive", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public Boolean getInactive() {
    return inactive;
  }

  public void setInactive(Boolean inactive) {
    this.inactive = inactive;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserResponse userResponse = (UserResponse) o;
    return Objects.equals(this.id, userResponse.id) &&
            Objects.equals(this.name, userResponse.name) &&
            Objects.equals(this.email, userResponse.email) &&
            Objects.equals(this.password, userResponse.password) &&
            Objects.equals(this.phones, userResponse.phones) &&
            Objects.equals(this.created, userResponse.created) &&
            Objects.equals(this.modified, userResponse.modified) &&
            Objects.equals(this.lastLogin, userResponse.lastLogin) &&
            Objects.equals(this.token, userResponse.token) &&
            Objects.equals(this.inactive, userResponse.inactive);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, email, password, phones, created, modified, lastLogin, token, inactive);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    phones: ").append(toIndentedString(phones)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    modified: ").append(toIndentedString(modified)).append("\n");
    sb.append("    lastLogin: ").append(toIndentedString(lastLogin)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    inactive: ").append(toIndentedString(inactive)).append("\n");
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

