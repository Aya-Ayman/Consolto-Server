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
import pojos.ListOfAllResultsPojo;
import pojos.PharmacyListPojo;
import pojos.PharmacyPojo;
import pojos.ResultListPojo;
import pojos.ResultPojo;

/**
 *
 * @author Hagar
 */
@Path("search")
public class SearchImplementation {

    @GET
    @Path("/getAll/{input}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultListPojo getAll(@PathParam("input") String input) {
        ArrayList<ResultPojo> results = new ArrayList();

      ResultListPojo obj = new ResultListPojo();
        HospitalImpl hospitalObj = new HospitalImpl();
        ArrayList<ResultPojo> hospitals = new ArrayList();
        hospitals = hospitalObj.searchHospitalByName(input);

        // ResultListPojo hospitalsList = new ResultListPojo();
        if (hospitals.size() != 0) {
            for (int i = 0; i < hospitals.size(); i++) {

                results.add(hospitals.get(i));

            }
        }

        ArrayList<ResultPojo> hospitals2 = new ArrayList();
        //   ResultListPojo hospitalsList2 = new ResultListPojo();
        hospitals2 = hospitalObj.searchHospitalByDepartment(input);
        //   hospitalsList.setResults(hospitals2);
        if (hospitals2.size() != 0) {

            for (int i = 0; i < hospitals2.size(); i++) {
                results.add(hospitals2.get(i));

            }
        }

        LabImpl labObj = new LabImpl();
        ArrayList<ResultPojo> labs = new ArrayList();
        labs = labObj.searchLabBySpecialization(input);

//        ResultListPojo labList = new ResultListPojo();
        if (labs.size()!= 0) {

            for (int i = 0; i < labs.size(); i++) {
                results.add(labs.get(i));

            }
        }

        ArrayList<ResultPojo> labs2 = new ArrayList();
        labs2 = labObj.searchLabByName(input);
        if (labs2.size() != 0) {
             for (int i = 0; i < labs2.size(); i++) {
                results.add(labs2.get(i));

            }
        }

        
        
        
        
        
        PharmacyImpl PharmacyObj = new PharmacyImpl();
        ArrayList<ResultPojo> pharmacies = new ArrayList();
        pharmacies = PharmacyObj.searchPharmacy(input);
        if (pharmacies.size() != 0) {
             for (int i = 0; i < pharmacies.size(); i++) {
                results.add(pharmacies.get(i));

            }
        }
        

        ClinicImpl clinicObj = new ClinicImpl();
        ArrayList<ResultPojo> clinics = new ArrayList();
        clinics = clinicObj.searchClinic(input);
        if (clinics.size() != 0) {
             for (int i = 0; i < clinics.size(); i++) {
                results.add(clinics.get(i));

            }
        }
        obj.setResults(results);
        System.out.println("results ="+results.size());

        return obj;
    }

}
