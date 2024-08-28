package com.zero.healerble.config;

import com.zero.healerble.common.type.Role;
import com.zero.healerble.entity.MemberEntity;
import java.util.ArrayList;
import java.util.Collection;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Slf4j
@Getter
public class UserAdapter extends User {

  private final MemberEntity memberEntity;

  public UserAdapter(MemberEntity memberEntity) {
    super(memberEntity.getEmail(),
        memberEntity.getPassword(),
        authorities(memberEntity.getMemberRole())
    );

    log.info(
        "SecurityUser user.id: " + memberEntity.getEmail() +
        "\n SecurityUser user.password: " + memberEntity.getPassword() +
        "\n SecurityUser user.role: " + memberEntity.getMemberRole()
    );

    this.memberEntity = memberEntity;
  }

  private static Collection<? extends GrantedAuthority> authorities(Role role) {
    Collection<GrantedAuthority> collection = new ArrayList<>();
    collection.add(new SimpleGrantedAuthority("ROLE_" + role));

    return collection;
  }

  @Override
  public String getPassword() {
    return memberEntity.getPassword();
  }

  @Override
  public String getUsername() {
    return memberEntity.getEmail();
  }
}
