package com.jax.ai.domain.openAi.model.aggregates;


import com.jax.ai.domain.openAi.model.vo.Choices;
import lombok.Data;

import java.util.List;

/**
 * @author jax
 * @description AI Answer
 */
@Data
public class AIAnswer {

    private String id;

    private String object;

    private int created;

    private String model;

    private List<Choices> choices;

}
