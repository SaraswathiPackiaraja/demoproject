package net.codejava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
// import org.springframework.web.bind.annotation.RequestParam;

import net.codejava.repository.RegisterRepository;
import net.codejava.model.GenericResponse;
import net.codejava.model.RegModel;
import net.codejava.model.UserModel;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/user")
public class UserRegistrationController {
    @Autowired
    private RegisterRepository regRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/validateUser", method = RequestMethod.POST, consumes = { "application/JSON" })
    public ResponseEntity<GenericResponse> validateUser(@RequestBody UserModel user) {

        GenericResponse retMsg = new GenericResponse();
        try {
            String value = regRepository.getUser(user.getUsername());
            if (value != null && value.equals(user.getPassword())) {
                retMsg.setSuccess(true);
                retMsg.setStatusMsg("successful.");
            } else {
                retMsg.setSuccess(false);
                retMsg.setStatusMsg("Password does not match");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            retMsg.setSuccess(false);
            retMsg.setStatusMsg("Exception occurred.");
        }

        ResponseEntity<GenericResponse> retVal;
        retVal = ResponseEntity.ok(retMsg);
        return retVal;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/adduser", method = RequestMethod.POST, consumes = { "application/JSON" })
    public ResponseEntity<GenericResponse> addUser(@RequestBody RegModel userToAdd) {

        GenericResponse retMsg = new GenericResponse();
        if (userToAdd != null) {
            try {
                int response = regRepository.addUser(userToAdd);
                if (response == 1) {
                    retMsg.setSuccess(true);
                    retMsg.setStatusMsg("successful.");
                } else {
                    retMsg.setSuccess(false);
                    retMsg.setStatusMsg("Exception occurred.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                retMsg.setSuccess(false);
                retMsg.setStatusMsg("Exception occurred.");
            }
        } else {
            retMsg.setSuccess(false);
            retMsg.setStatusMsg("No valid data to be added");
        }

        ResponseEntity<GenericResponse> retVal;
        retVal = ResponseEntity.ok(retMsg);
        return retVal;
    }
}