package pl.kodolamacz.mvc.controllers.forms;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * Created by acacko on 18.11.17
 */
public class AddUserForm {

  @Email
  private String email;

  @NotBlank
  @Min(8)
//  @Size(min = 8, max = 500)
  private String password;

  public AddUserForm(@Email String email, @NotBlank @Min(8) String password) {
    this.email = email;
    this.password = password;
  }

  public AddUserForm() {}


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
