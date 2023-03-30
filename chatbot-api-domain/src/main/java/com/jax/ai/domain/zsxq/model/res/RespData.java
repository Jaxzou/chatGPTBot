package com.jax.ai.domain.zsxq.model.res;


import com.jax.ai.domain.zsxq.model.vo.Topics;
import lombok.Data;

import java.util.List;

/**
 * @author jax
 * @description 结果数据
 */
@Data
public class RespData {

    private List<Topics> topics;
}
