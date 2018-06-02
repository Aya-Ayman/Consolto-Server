/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.implementation;

import dao.Implementation.clinic.ClinicImpl;
import dao.Implementation.hospital.HospitalImpl;
import dao.Implementation.lab.LabImpl;
import dao.Implementation.pharmacy.PharmacyImpl;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pojos.ClinicListPojo;
import pojos.ClinicPojo;
import pojos.HospitalListPojo;
import pojos.HospitalPojo;
import pojos.LabListPojo;
import pojos.LabPojo;
import pojos.PharmacyListPojo;
import pojos.PharmacyPojo;
import pojos.ResultListPojo;

/**
 *
 * @author Hagar
 */
@Path("search")
public class SearchImplementation {

    @GET
    @Path("/clinic/{input}")
    @Produces(MediaType.APPLICATION_JSON)
    public ClinicListPojo getAllClinics(@PathParam("input") String input) {

        ClinicImpl clinicObj = new ClinicImpl();
        ArrayList<ClinicPojo> clinics = new ArrayList();
        ClinicListPojo clinicList = new ClinicListPojo();
        clinics = clinicObj.searchClinic(input);
        clinicList.setClinics(clinics);
        return clinicList;
    }

    @GET
    @Path("/pharmacy/{input}")
    @Produces(MediaType.APPLICATION_JSON)
    public PharmacyListPojo getAllPharmacies(@PathParam("input") String input) {

        PharmacyImpl PharmacyObj = new PharmacyImpl();
        ArrayList<PharmacyPojo> pharmacies = new ArrayList();
        PharmacyListPojo pharmacyList = new PharmacyListPojo();
        pharmacies = PharmacyObj.searchPharmacy(input);
        pharmacyList.setPharmacies(pharmacies);
        return pharmacyList;
    }

    @GET
    @Path("/lab/{input}")
    @Produces(MediaType.APPLICATION_JSON)
    public LabListPojo getAllLabsByName(@PathParam("input") String input) {
        System.out.println("inside getAllLabsByName");
        LabImpl labObj = new LabImpl();
        ArrayList<LabPojo> labs = new ArrayList();
        LabListPojo labList = new LabListPojo();
        labs = labObj.searchLabByName(input);
        System.out.println("labs " + labs.size());

        labList.setLabs(labs);
        return labList;
    }

    @GET
    @Path("/specialization/{input}")
    @Produces(MediaType.APPLICATION_JSON)
    public LabListPojo getAllLabsBySpecialization(@PathParam("input") String input) {

        LabImpl labObj = new LabImpl();
        ArrayList<LabPojo> labs = new ArrayList();
        LabListPojo labList = new LabListPojo();
        labs = labObj.searchLabBySpecialization(input);
        labList.setLabs(labs);
        return labList;
    }

    @GET
    @Path("/hospital/{input}")
    @Produces(MediaType.APPLICATION_JSON)
    public HospitalListPojo getAllHospitalsByName(@PathParam("input") String input) {
        HospitalImpl hospitalObj = new HospitalImpl();
        ArrayList<HospitalPojo> hospitals = new ArrayList();
        HospitalListPojo hospitalsList = new HospitalListPojo();
        hospitals = hospitalObj.searchHospitalByName(input);

        hospitalsList.setHospitals(hospitals);
        return hospitalsList;
    }

    @GET
    @Path("/department/{input}")
    @Produces(MediaType.APPLICATION_JSON)
    public HospitalListPojo getAllHospitalsByDepartments(@PathParam("input") String input) {

        HospitalImpl hospitalObj = new HospitalImpl();
        ArrayList<HospitalPojo> hospitals = new ArrayList();
        HospitalListPojo hospitalsList = new HospitalListPojo();
        hospitals = hospitalObj.searchHospitalByDepartment(input);

        hospitalsList.setHospitals(hospitals);
        return hospitalsList;
    }

    @GET
    @Path("/getAll/{input}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultListPojo getAll(@PathParam("input") String input) {
        ArrayList<Object> results = new ArrayList();
         ResultListPojo obj = new ResultListPojo();
         
        HospitalImpl hospitalObj = new HospitalImpl();
        ArrayList<HospitalPojo> hospitals = new ArrayList();
        HospitalListPojo hospitalsList = new HospitalListPojo();
        hospitals = hospitalObj.searchHospitalByName(input);
        hospitalsList.setHospitals(hospitals);
        if (hospitals.size() != 0) {
            results.add(hospitalsList);
        }

        ArrayList<HospitalPojo> hospitals2 = new ArrayList();
        HospitalListPojo hospitalsList2 = new HospitalListPojo();
        hospitals2 = hospitalObj.searchHospitalByDepartment(input);
        hospitalsList2.setHospitals(hospitals2);
        if (hospitals2.size() != 0) {
            results.add(hospitalsList2);
        }

        LabImpl labObj = new LabImpl();
        ArrayList<LabPojo> labs = new ArrayList();
        LabListPojo labList = new LabListPojo();
        labs = labObj.searchLabBySpecialization(input);
        labList.setLabs(labs);
        if (labs.size() != 0) {
            results.add(labList);
        }

        ArrayList<LabPojo> labs2 = new ArrayList();
        LabListPojo labList2 = new LabListPojo();
        labs2 = labObj.searchLabByName(input);
        labList2.setLabs(labs2);
        if (labs2.size() != 0) {
            results.add(labList2);
        }

        PharmacyImpl PharmacyObj = new PharmacyImpl();
        ArrayList<PharmacyPojo> pharmacies = new ArrayList();
        PharmacyListPojo pharmacyList = new PharmacyListPojo();
        pharmacies = PharmacyObj.searchPharmacy(input);
        pharmacyList.setPharmacies(pharmacies);
        if (pharmacies.size() != 0) {
            results.add(pharmacyList);
        }

        ClinicImpl clinicObj = new ClinicImpl();
        ArrayList<ClinicPojo> clinics = new ArrayList();
        ClinicListPojo clinicList = new ClinicListPojo();
        clinics = clinicObj.searchClinic(input);
        clinicList.setClinics(clinics);
        if (clinics.size() != 0) {
            results.add(clinicList);
        }
            obj.setResults(results);

        return obj;
    }

}
