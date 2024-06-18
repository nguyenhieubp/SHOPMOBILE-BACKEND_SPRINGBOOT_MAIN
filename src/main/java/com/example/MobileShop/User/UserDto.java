package com.example.MobileShop.User;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.UUID;

public class UserDto {
        @Valid

        private UUID userId;

        @NotEmpty(message = "Cần nhập user name")
        private String userName;

        @Email()
        @NotEmpty(message = "Cần có email")
        private String email;

        @Length(min = 8, max = 200,message = "mật khẩu ít nhất 8 ký tự")
        @NotEmpty(message = "cần có pasword")
        private String password;

        private String refresh_token;

        private Date created_at;

        private Date updated_at;

        public UUID getUserId() {
                return userId;
        }

        public void setUserId(UUID userId) {
                this.userId = userId;
        }

        public @NotEmpty(message = "Cần nhập user name") String getUserName() {
                return userName;
        }

        public void setUserName(@NotEmpty(message = "Cần nhập user name") String userName) {
                this.userName = userName;
        }

        public @Email() @NotEmpty(message = "Cần có email") String getEmail() {
                return email;
        }

        public void setEmail(@Email() @NotEmpty(message = "Cần có email") String email) {
                this.email = email;
        }

        public @Length(min = 8, max = 200) String getPassword() {
                return password;
        }

        public void setPassword(@Length(min = 8, max = 200) String password) {
                this.password = password;
        }

        public String getRefresh_token() {
                return refresh_token;
        }

        public void setRefresh_token(String refresh_token) {
                this.refresh_token = refresh_token;
        }

        public Date getCreated_at() {
                return created_at;
        }

        public void setCreated_at(Date created_at) {
                this.created_at = created_at;
        }

        public Date getUpdated_at() {
                return updated_at;
        }

        public void setUpdated_at(Date updated_at) {
                this.updated_at = updated_at;
        }

        public UserDto() {
                this.created_at = new Date();
                this.updated_at = new Date();
        }

        @Override
        public String toString() {
                return "UserDto{" +
                        "userId=" + userId +
                        ", userName='" + userName + '\'' +
                        ", email='" + email + '\'' +
                        ", password='" + password + '\'' +
                        ", refresh_token='" + refresh_token + '\'' +
                        ", created_at=" + created_at +
                        ", updated_at=" + updated_at +
                        '}';
        }
}
