package com.github.sidneymiranda.lojavirtual.annotations;

import org.springframework.security.test.context.support.WithMockUser;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@WithMockUser(username = "tester", password = "8e4b008c-ba23-4390-b88b-4361cabda285", roles = "TESTER")
public @interface WithMockTester {
}
