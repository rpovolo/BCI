package com.bci.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.annotation.Generated;
import java.util.Objects;

/**
 * The Phone model.
 */

@Schema(name = "Phone", description = "The Phone model.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-19T16:29:52.681604746-03:00[America/Argentina/Mendoza]")
public class Phone {

  @JsonProperty("number")
  private String number;

  @JsonProperty("citycode")
  private String citycode;

  @JsonProperty("countrycode")
  private String countrycode;

  public Phone number(String number) {
    this.number = number;
    return this;
  }

  /**
   * A string attribute representing a specific number, such as an address number or a unique identifier.
   * @return number
  */
  
  @Schema(name = "number", description = "A string attribute representing a specific number, such as an address number or a unique identifier.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Phone citycode(String citycode) {
    this.citycode = citycode;
    return this;
  }

  /**
   * A string attribute storing the code of the associated city. This code can uniquely identify a city in a system or database
   * @return citycode
  */
  
  @Schema(name = "citycode", description = "A string attribute storing the code of the associated city. This code can uniquely identify a city in a system or database", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getCitycode() {
    return citycode;
  }

  public void setCitycode(String citycode) {
    this.citycode = citycode;
  }

  public Phone countrycode(String countrycode) {
    this.countrycode = countrycode;
    return this;
  }

  /**
   * A string attribute holding the code of the corresponding country.
   * @return countrycode
  */
  
  @Schema(name = "countrycode", description = "A string attribute holding the code of the corresponding country.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getCountrycode() {
    return countrycode;
  }

  public void setCountrycode(String countrycode) {
    this.countrycode = countrycode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Phone phone = (Phone) o;
    return Objects.equals(this.number, phone.number) &&
        Objects.equals(this.citycode, phone.citycode) &&
        Objects.equals(this.countrycode, phone.countrycode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, citycode, countrycode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Phone {\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    citycode: ").append(toIndentedString(citycode)).append("\n");
    sb.append("    countrycode: ").append(toIndentedString(countrycode)).append("\n");
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

