/*
 * package com.oee.controller;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.oee.dto.incoming.UserIncomingDto; import
 * com.oee.dto.response.Response; import com.oee.service.UserService;
 * 
 * import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
 * 
 * import java.util.Objects;
 * 
 * @RestController
 * 
 * @RequestMapping(path = {"/api/v1/user"}, produces = APPLICATION_JSON_VALUE)
 * public class UserController1 {
 * 
 * @Autowired private UserService userService;
 * 
 * @PostMapping("/register") public Response register(@RequestBody
 * UserIncomingDto userIncomingDto) { //return userRepository.save(user); return
 * Response.created().setPayload(userService.addUser(userIncomingDto)); }
 * 
 * }
 */