package cl.maraneda.backend.controller;

import cl.maraneda.backend.dto.UnaryComplexOperationInputDTO;
import cl.maraneda.cplx.ComplexMath;
import cl.maraneda.cplx.ComplexNumber;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/complex")
public class ComplexController {

    @PostMapping("/conjugate")
    public ResponseEntity<@NonNull String> conjugate(@RequestBody UnaryComplexOperationInputDTO input){
        ComplexNumber cnin = ComplexNumber.fromOrderedPair(input.getCnumber());
        ComplexNumber cnout = ComplexMath.conjugate(cnin);
        return ResponseEntity.ok(cnout.toString());
    }
}
