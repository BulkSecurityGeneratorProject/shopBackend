package es.prettychic.online.service.mapper;

import es.prettychic.online.domain.User;
import es.prettychic.online.service.dto.UserDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2016-11-08T12:48:06+0100",
    comments = "version: 1.0.0.Final, compiler: Eclipse JDT (IDE) 3.11.2.v20160128-0629, environment: Java 1.8.0_51 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        if ( userDTO.getAuthorities() != null ) {
            Collection<String> targetCollection = stringsFromAuthorities( user.getAuthorities() );
            if ( targetCollection != null ) {
                userDTO.getAuthorities().addAll( targetCollection );
            }
        }

        return userDTO;
    }

    @Override
    public List<UserDTO> usersToUserDTOs(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>();
        for ( User user : users ) {
            list.add( userToUserDTO( user ) );
        }

        return list;
    }

    @Override
    public User userDTOToUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setLogin( userDTO.getLogin() );
        user.setFirstName( userDTO.getFirstName() );
        user.setLastName( userDTO.getLastName() );
        user.setEmail( userDTO.getEmail() );
        user.setActivated( userDTO.isActivated() );
        user.setLangKey( userDTO.getLangKey() );
        user.setAuthorities( authoritiesFromStrings( userDTO.getAuthorities() ) );

        return user;
    }

    @Override
    public List<User> userDTOsToUsers(List<UserDTO> userDTOs) {
        if ( userDTOs == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>();
        for ( UserDTO userDTO : userDTOs ) {
            list.add( userDTOToUser( userDTO ) );
        }

        return list;
    }
}
