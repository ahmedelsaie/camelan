package camelon.utils;

import camelon.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserFromHeaderConverter implements Converter<String, User> {

    @SneakyThrows
    @Override
    public User convert(final String user) {

        User retUser = new ObjectMapper().readValue(user, User.class);

        retUser.setId(Long.valueOf(retUser.getId()));
        return retUser;

    }
}
