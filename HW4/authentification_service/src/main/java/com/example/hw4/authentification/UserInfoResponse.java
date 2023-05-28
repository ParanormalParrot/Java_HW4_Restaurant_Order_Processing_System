package com.example.hw4.authentification;

import com.example.hw4.user.Role;
import com.example.hw4.user.Role;
import com.example.hw4.Session;
import lombok.*;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoResponse extends Response{

    private String username;
    private String email;
    private Role role;
    private Date createdAt;
    private Date updatedAt;
    private List<Session> sessions;
}