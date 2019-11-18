package cn.lingshi.tree.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: VmDomain
 * @Create By: chenxihua
 * @Date: 2019/11/15 10:51
 **/

@Data
@Entity
@Table(name = "vm_domainmap")
public class VmDomain implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DOMAIN_ID")
    private Integer domainId;

    @Column(name = "DOMAIN_NAME")
    private String domainName;

    @Column(name = "DOMAIN_VNGSID")
    private String domainVngsId;

    @Column(name = "DOMAIN_ALLPARENTID")
    private String domainAllParentId;

    @Column(name = "PARENT_ID")
    private Integer parentId;

    @Column(name = "DOMAIN_GBCODE")
    private String domainGbCode;

    @Column(name = "START_ID")
    private Integer startId;

    @Column(name = "CURRENT_ID")
    private Integer currentId;

    @Column(name = "SORT_ID")
    private Integer sortId;

    @Column(name = "PLATFORM_ID")
    private String platformId;

    @Column(name = "DOMAIN_CATEGORY")
    private Integer domainCategory;

    @Transient
    List<VmDomain> vmDomains;



}
