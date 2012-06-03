package be.jeffreyvanmulem.brandstof.model;

import be.jeffreyvanmulem.brandstof.model.abstr.DomainObjectType;
import be.jeffreyvanmulem.brandstof.model.types.FillingType;
import be.jeffreyvanmulem.brandstof.model.types.FuelType;
import be.jeffreyvanmulem.brandstof.model.types.Tag;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 7/05/12
 * Time: 18:25
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Fillup")
public class Fillup extends DomainObjectType {

    @ManyToOne
    @JoinColumn(name = "Car_id")
    private Car car;

    @Column(name = "Date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GasStation_id")
    private GasStation gasStation;

    @Column(name = "LicensePlate")
    private String licensePlate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FuelType_id")
    private FuelType fuelType;

    @Column(name = "Liters")
    private float liters;

    @Column(name = "CostPerLiter")
    private float costPerLiter;

    @Column(name = "Cost")
    private float cost;

    @Column(name = "Mileage")
    private float mileage;

    @Column(name = "MilageSinceLastFillup")
    private float mileageSinceLastFillup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FillingType_id")
    private FillingType fillingType;

    @Column(name = "Note")
    private String note;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "Tag_id")
    private Set<Tag> tags = new HashSet<Tag>();

    @Column(name = "Accurate")
    private boolean accurate = Boolean.TRUE;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public GasStation getGasStation() {
        return gasStation;
    }

    public void setGasStation(GasStation gasStation) {
        this.gasStation = gasStation;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public float getLiters() {
        return liters;
    }

    public void setLiters(float liters) {
        this.liters = liters;
    }

    public float getCostPerLiter() {
        return costPerLiter;
    }

    public void setCostPerLiter(float costPerLiter) {
        this.costPerLiter = costPerLiter;
    }

    public FillingType getFillingType() {
        return fillingType;
    }

    public void setFillingType(FillingType fillingType) {
        this.fillingType = fillingType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getMileage() {
        return mileage;
    }

    public void setMileage(float mileage) {
        this.mileage = mileage;
    }

    public float getMileageSinceLastFillup() {
        return mileageSinceLastFillup;
    }

    public void setMileageSinceLastFillup(float mileageSinceLastFillup) {
        this.mileageSinceLastFillup = mileageSinceLastFillup;
    }

    public boolean isAccurate() {
        return accurate;
    }

    public void setAccurate(boolean accurate) {
        this.accurate = accurate;
    }
}
