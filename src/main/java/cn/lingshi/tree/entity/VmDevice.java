package cn.lingshi.tree.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ClassName: VmDevice
 * @Create By: chenxihua
 * @Date: 2019/11/15 10:51
 **/

@Data
@Entity
@Table(name = "vm_devinfo")
public class VmDevice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEV_ID")
    private Integer devId;

    @Column(name = "DOMAIN_ID")
    private Integer domainId;

    @Column(name = "DEV_NAME")
    private String devName;

    @Column(name = "DEV_CATEGORY")
    private Integer devCategory;

    @Column(name = "DEV_SERVICE")
    private Integer devService;

    @Column(name = "DEV_RECID")
    private Integer devRecId;

    @Column(name = "MODEL_ID")
    private Integer modelId;

    @Column(name = "DEV_GBCODE")
    private String devGbCode;

    @Column(name = "CHNN_ID")
    private Integer chnnId;

    @Column(name = "DEV_IP")
    private String devIp;

    @Column(name = "DEV_PORT")
    private Integer devPort;

    @Column(name = "DEV_USER")
    private String devUser;

    @Column(name = "DEV_PWD")
    private String devPwd;

    @Column(name = "DEV_FACADE")
    private Integer devFacade;

    @Column(name = "DEV_GOVIDEOID")
    private Integer devGovideoId;

    @Column(name = "DEV_GOVNGSID")
    private String devGoVngsId;

    @Column(name = "SORT_ID")
    private Double sortId;

    @Column(name = "PLAT_FORMID")
    private String platformId;

    @Column(name = "CHNN_INDEX")
    private Integer chnnIndex;

    @Column(name = "LOCATION")
    private String location;



}
