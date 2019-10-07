package com.sut.sa.g13.Entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;


@Data
@Entity
@NoArgsConstructor
@Table(name="SPORTEQUIPMENT")
public class SportEquipment {
	@Id
	@SequenceGenerator(name="sportequipment_seq",sequenceName="sportequipment_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sportequipment_seq")
	@Column(name="SPORTEQUIPMENT_ID",unique = true, nullable = true)
   
    private @NonNull Long sportequipmentid;
    private @NonNull String equipment; //edit
    private @NonNull Integer number; //edit
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Employee.class)
    @JoinColumn(name = "EMPLOYEE" , insertable = true)
    private Employee employeeid;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TypeEquipment.class)
    @JoinColumn(name = "TYPEEQUIMENT" , insertable = true)
    private TypeEquipment typeequipmentid;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Status.class)
    @JoinColumn(name = "STATUS", insertable = true)
    private Status statusid; //edit

}