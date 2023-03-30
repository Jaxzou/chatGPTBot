package com.jax.ai.domain.zsxq.model.vo;

import lombok.Data;

/**
 * @author jax
 */
@Data
public class Question {

    private Owner owner;

    private Questionee questionee;

    private String text;

    private boolean expired;

    private boolean anonymous;

    private OwnerDetail owner_detail;

    private String owner_location;
}
