package br.com.mili.milibackend.gfd.application.policy;

import br.com.mili.milibackend.shared.infra.security.model.CustomUserPrincipal;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

import static br.com.mili.milibackend.gfd.shared.roles.GfdPermissions.Geral.*;

@Component
public class GfdPolicy implements IGfdPolicy {

    public boolean isAnalista(CustomUserPrincipal user) {
        return hasRole(user, ANALISTA) || hasRole(user, SESMT) || hasRole(user, PORTARIA) || hasRole(user, FABRICA);
    }

    public boolean isFornecedor(CustomUserPrincipal user) {
        return hasRole(user, FORNECEDOR);
    }

    private boolean hasRole(CustomUserPrincipal user, String role) {
        Set<String> roles = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());
        return roles.contains(role);
    }

}
