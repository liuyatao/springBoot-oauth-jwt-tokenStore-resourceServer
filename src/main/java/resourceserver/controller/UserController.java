package resourceserver.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.web.bind.annotation.*;
import resourceserver.data.pojo.User;

import java.util.HashMap;
import java.util.concurrent.Callable;

/**
 * Created by Izzy on 17/08/15.
 */
@RestController
public class UserController {

    static final String USER_URL_PATH = "/user";
    @Autowired
    private DefaultTokenServices tokenServices;

    @RequestMapping(value = USER_URL_PATH + "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_USER') and #oauth2.hasScope('SIGNED_IN')")
    public User test (OAuth2Authentication authentication) {

        return (User) authentication.getPrincipal();
    }

    @RequestMapping(value = USER_URL_PATH + "/test2", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_USER') and #oauth2.hasScope('REMEMBERED')")
    public User test2 (OAuth2Authentication authentication) {

        return (User) authentication.getPrincipal();
    }

}
