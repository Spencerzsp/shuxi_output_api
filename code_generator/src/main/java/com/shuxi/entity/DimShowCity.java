package com.shuxi.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 跺璐ц剧ず
 * </p>
 *
 * @author yu hao
 * @since 2021-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DimShowCity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 瑕剧ず
     */
    private String city;

    private String longitude;

    private String latitude;


}
