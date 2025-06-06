package br.com.mili.milibackend.user.application.service;

import br.com.mili.milibackend.shared.infra.security.model.Roles;
import br.com.mili.milibackend.shared.infra.security.service.AuthService;
import br.com.mili.milibackend.shared.util.Util;
import br.com.mili.milibackend.user.domain.entity.User;
import br.com.mili.milibackend.user.infra.repository.UserRepository;
import br.com.mili.milibackend.user.infra.repository.projection.UserFindUserByUsername;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    private final AuthService authService;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, AuthService authService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.authService = authService;
    }

    public User findByUsername(String username) {
        UserFindUserByUsername userFound = userRepository.findByUsername(username);

        if (userFound == null)
            throw new UsernameNotFoundException(username);

        var user = modelMapper.map(userFound, User.class);

        if (userFound.getIsHex().equals("F"))
            user.setPassword(Util.decodificarPass(user.getPassword()));

        List<Roles> listAuth = authService.getRolesByUserId(user.getId());

        List<String> listAuthString = new ArrayList<String>();

        listAuth.forEach(role -> {
            role.getAuthorities().forEach(authority -> {
                listAuthString.add(role.getSystemId() + "__" + authority);
            });
        });

        user.setAuthorities(listAuthString);
        return user;
    }

}
