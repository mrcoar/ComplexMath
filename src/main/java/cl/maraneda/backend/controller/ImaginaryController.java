package cl.maraneda.backend.controller;

import cl.maraneda.backend.dto.BinaryImaginaryOperationInputDTO;
import cl.maraneda.backend.dto.ComplexListOutputDTO;
import cl.maraneda.backend.dto.ImaginaryExpAndBasePowInputDTO;
import cl.maraneda.backend.dto.BinaryImaginaryAndRealOperationInputDTO;
import cl.maraneda.backend.dto.BinaryImaginaryAndIntOperationInputDTO;
import cl.maraneda.backend.dto.ImaginaryArrayInputDTO;
import cl.maraneda.backend.dto.BinaryImaginaryAndRealArrayOperationInputDTO;
import cl.maraneda.backend.dto.UnaryImaginaryOperationInputDTO;
import cl.maraneda.backend.service.ImaginaryService;
import cl.maraneda.cplx.ComplexNumber;
import cl.maraneda.cplx.ImaginaryNumber;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/complexMath/imaginary")
@Tag(
        name = "Imaginary Numbers",
        description = "Operations for creating and manipulating imaginary numbers"
)
public class ImaginaryController {

    private final ImaginaryService imaginaryService;

    @Autowired
    public ImaginaryController(ImaginaryService imaginaryService){
        this.imaginaryService = imaginaryService;
    }

    @GetMapping("/pow/imaginaryUnit")
    @Operation(
            summary = "Raises the imaginary unit to the power of an integer",
            description = """
                Receives an integer from a query string and uses it to raise
                the imaginary unit (sqrt(-1)) to the specified power.
                The result depends on the value of m = exp MOD 4. If m is
                1, the result is i. If m is 2, the result is -1. If m is 3, the
                result is -i. If m is zero, the result is 1.
                """
    )
    @ApiResponse(responseCode = "200", description = "Power calculated successfully")
    @ApiResponse(responseCode = "400", description = "Null or non-integer input")
    @ApiResponse(responseCode = "500", description = "Internal error")
    public ResponseEntity<String> imaginaryUnitPow(
            @Parameter(
                in = ParameterIn.QUERY,
                name = "withExponent",
                description = "Exponent used to raise the imaginary unit to the power of",
                example = "2",
                required = true
            )
            @RequestParam("withExponent") int exp){
        return ResponseEntity.ok(imaginaryService.pow(exp).toString());
    }

    @PostMapping("/pow/imaginaryBase/intExp")
    @Operation(
            summary = "Raises one imaginary number to the power of an integer",
            description = """
                Receives a string representing an imaginary number and an integer
                exponent from a request body to raise the imaginary number to the
                power of the specified exponent.
                The result depends on the value of m = exp MOD 4 as indicated in
                the power of the imaginary unit.
                """
    )
    @ApiResponse(responseCode = "200", description = "Power calculated successfully")
    @ApiResponse(responseCode = "400", description = "Null or invalid imaginary input")
    @ApiResponse(responseCode = "500", description = "Internal error")
    public ResponseEntity<String> pow(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Required input to calculate the power",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = BinaryImaginaryAndIntOperationInputDTO.class
                            )
                    )
            )
            @RequestBody BinaryImaginaryAndIntOperationInputDTO input){
        ImaginaryNumber in = ImaginaryNumber.fromString(input.getInput());
        int exp = input.getIinput();
        return ResponseEntity.ok(imaginaryService.pow(in, exp).toString());
    }

    @Operation(
        summary = "Raises one real number to the power of an imaginary number",
        description = """
            Receives a string representing an imaginary number and a real base
            from a request body to raise the real number to the
            power of the specified imaginary exponent.
            The result is a complex number whose real part is cos(exp * log(base))
            and its imaginary part is sin(exp * log(base)), where exp is the
            numeric coefficient of the imaginary number.
            """
    )
    @ApiResponse(responseCode = "200", description = "Power calculated successfully")
    @ApiResponse(responseCode = "400", description = "Null or invalid imaginary input")
    @ApiResponse(responseCode = "500", description = "Internal error")
    @PostMapping("/pow/realBase/imaginaryExp")
    public ResponseEntity<String> pow(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Required input to calculate the power",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = BinaryImaginaryAndRealOperationInputDTO.class
                            )
                    )
            )
            @RequestBody BinaryImaginaryAndRealOperationInputDTO input){
        ImaginaryNumber exp = ImaginaryNumber.fromString(input.getInput());
        double base = input.getRinput();
        return ResponseEntity.ok(imaginaryService.pow(base, exp).toString());
    }

    @Operation(
            summary = "Raises one imaginary number to the power of another imaginary number",
            description = """
            Receives two strings representing an imaginary number for a base and
            a exponent and an optional integer from a request body to raise
            the imaginary base to the power of the specified imaginary exponent,
            using the kth value of the natural logarithm of the base if k is present.
            Otherwise, the principal value of that logarithm will be used instead
            (that is, the value of the logarithm for k = 0)
            The result is a complex number that results of raise the E constant to
            the power of the product between the exponent and the kth logarithm of the
            base.
            """
    )
    @ApiResponse(responseCode = "200", description = "Power calculated successfully")
    @ApiResponse(responseCode = "400", description = "Null or invalid imaginary input")
    @ApiResponse(responseCode = "500", description = "Internal error")
    @PostMapping("/pow/imaginaryExp/imaginaryBase")
    public ResponseEntity<String> pow(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Required input to calculate the power",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = ImaginaryExpAndBasePowInputDTO.class
                            )
                    )
            )
            @RequestBody ImaginaryExpAndBasePowInputDTO input){
        ImaginaryNumber exp = ImaginaryNumber.fromString(input.getInput());
        ImaginaryNumber base = ImaginaryNumber.fromString(input.getBase());
        return ResponseEntity.ok(imaginaryService.pow(base, exp, input.getK()).toString());
    }

    @Operation(
            summary = "Calculates the sum of two or more imaginary numbers",
            description = """
            Receives an array of strings in which each element must be an
            valid imaginary number. Also, the array must contain two or
            more elements.
            The result is an imaginary number whose numeric coefficient is
            the sum between the numeric coefficient of each summand.
            """
    )
    @ApiResponse(responseCode = "200", description = "Sum calculated successfully")
    @ApiResponse(responseCode = "400", description = "Null or empty array or an array with less than 2 elements or at least one element is not a valid imaginary number")
    @ApiResponse(responseCode = "500", description = "Internal error")
    @PostMapping("/sum")
    public ResponseEntity<String> sum(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Required input to calculate the sum",
            required = true,
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(
                        implementation = ImaginaryArrayInputDTO.class
                )
            )
        )
        @RequestBody ImaginaryArrayInputDTO operands){
        ImaginaryNumber[] iops = Arrays.stream(operands.getOps()).map(ImaginaryNumber::fromString).toArray(ImaginaryNumber[]::new);
        return ResponseEntity.ok(imaginaryService.sum(iops).toString());
    }

    @Operation(
            summary = "Calculates the sum of one or more imaginary numbers with one or more real numbers",
            description = """
            Receives an array of strings in which each element must be an
            valid imaginary number and an array of numbers.
            Also, both arrays must have a total of two or more elements.
            The result is an imaginary number whose numeric coefficient is
            the sum between the numeric coefficient of each summand if the
            array of real numbers is not present; a real number if the array
            of imaginary numbers is not present; or a complex number if both
            arrays are present and the result of the sum between all imaginary
            numbers has a non-zero coefficient.
            """
    )
    @ApiResponse(responseCode = "200", description = "Sum calculated successfully")
    @ApiResponse(responseCode = "400", description = """
        Null or empty array(s) or an array with less than 2 elements
        or there is only one element among both arrays
        or at least one element is not a valid imaginary number
    """)
    @ApiResponse(responseCode = "500", description = "Internal error")
    @PostMapping("/sum/withDouble")
    public ResponseEntity<String> sum(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "Required input to calculate the sum",
                required = true,
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                implementation = BinaryImaginaryAndRealArrayOperationInputDTO.class
                        )
                )
        )
        @RequestBody BinaryImaginaryAndRealArrayOperationInputDTO operands){
        String[] siops = operands.getOps();
        ImaginaryNumber[] iops = null;
        if(siops!=null) {
            iops = Arrays.stream(operands.getOps()).map(ImaginaryNumber::fromString).toArray(ImaginaryNumber[]::new);
        }
        double[] rops = operands.getRops();
        return ResponseEntity.ok(imaginaryService.sum(rops, iops).toString());
    }

    @Operation(
            summary = "Calculates the product of two or more imaginary numbers",
            description = """
            Receives an array of strings in which each element must be an
            valid imaginary number. Also, the array must contain two or
            more elements.
            The result can be a real or an imaginary number depending on the
            number of factors, as this is the same as to multiply the numeric
            coefficients of all of them with the imaginary unit raised to the
            power of the number of factors.
            """
    )
    @ApiResponse(responseCode = "200", description = "Multiplication calculated successfully")
    @ApiResponse(responseCode = "400", description = "Null or invalid imaginary number")
    @ApiResponse(responseCode = "500", description = "Internal error")
    @PostMapping("/multiply")
    public ResponseEntity<String> multiply(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Required input to calculate the multiplication",
            required = true,
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ImaginaryArrayInputDTO.class)
            )
        )
        @RequestBody ImaginaryArrayInputDTO ops){
        ImaginaryNumber[] iops = Arrays.stream(ops.getOps()).map(ImaginaryNumber::fromString).toArray(ImaginaryNumber[]::new);
        return ResponseEntity.ok(imaginaryService.multiply(iops).toString());
    }

    @Operation(
            summary = "Multiplies one real number with one imaginary number",
            description = """
            Receives a string representing an imaginary number and a real number
            from a request body to multiply them both.
            The result is an imaginary number whose numeric coefficient is the
            product between the imaginary input's numeric coefficient and the
            real input. SPECIAL CASE: If the real input is zero, the result is
            also zero.
            """
    )
    @ApiResponse(responseCode = "200", description = "Multiplication calculated successfully")
    @ApiResponse(responseCode = "400", description = "Null or non-valid imaginary input")
    @ApiResponse(responseCode = "500", description = "Internal error")
    @PostMapping("/multiply/oneReal/oneImaginary")
    public ResponseEntity<String> multiply(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Required input to calculate the multiplication",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = BinaryImaginaryAndRealOperationInputDTO.class
                            )
                    )
            )
            @RequestBody BinaryImaginaryAndRealOperationInputDTO input){
        ImaginaryNumber ifactor = ImaginaryNumber.fromString(input.getInput());
        double dfactor = input.getRinput();
        return ResponseEntity.ok(imaginaryService.multiply(dfactor, ifactor).toString());
    }

    @Operation(
            summary = "Calculates the product of one or more imaginary numbers with one or more real numbers",
            description = """
            Receives an array of strings in which each element must be an
            valid imaginary number and an array of numbers.
            Also, both arrays must have a total of two or more elements.
            The result can be a real or imaginary number, depending on the
            number of imaginary factors, as this is the same as calculate
            the product of all real numbers (if any), the numeric coefficient
            of all imaginary numbers (if any) and the imaginary unit raised to
            the power of the number of imaginary factors (if any).
            SPECIAL CASE: If at least one of the real factors is zero, the result
            is also zero.
            """
    )
    @ApiResponse(responseCode = "200", description = "Multiplication calculated successfully")
    @ApiResponse(responseCode = "400", description = """
            Null or empty array(s) or
            an array with less than 2 elements
            or there is only one element among both arrays
            or at least one element is not a valid imaginary number
        """)
    @ApiResponse(responseCode = "500", description = "Internal error")
    @PostMapping("/multiply/multipleReal/multipleImaginary")
    public ResponseEntity<String> multiply(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Required input to calculate the multiplication",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = BinaryImaginaryAndRealArrayOperationInputDTO.class
                            )
                    )
            )
            @RequestBody BinaryImaginaryAndRealArrayOperationInputDTO operands){
        String[] siops = operands.getOps();
        ImaginaryNumber[] iops = null;
        if(siops!=null) {
            iops = Arrays.stream(operands.getOps()).map(ImaginaryNumber::fromString).toArray(ImaginaryNumber[]::new);
        }
        double[] rops = operands.getRops();
        return ResponseEntity.ok(imaginaryService.multiply(rops, iops).toString());
    }

    @Operation(
            summary = "Divides two imaginary numbers",
            description = """
            Receives two strings that must represent valid imaginary numbers.
            Due to algebraic properties, the result of the division will always
            be a real number.
            """
    )
    @ApiResponse(responseCode = "200", description = "Division calculated successfully")
    @ApiResponse(responseCode = "400", description = "Null or invalid imaginary number(s)")
    @ApiResponse(responseCode = "500", description = "Internal error")
    @PostMapping("/divide")
    public ResponseEntity<Double> divide(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Required input to calculate the division",
            required = true,
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(
                    implementation = BinaryImaginaryOperationInputDTO.class
                )
            )
        )
        @RequestBody BinaryImaginaryOperationInputDTO input){
        ImaginaryNumber i1 = ImaginaryNumber.fromString(input.getInput());
        ImaginaryNumber i2 = ImaginaryNumber.fromString(input.getInput2());
        return ResponseEntity.ok(imaginaryService.divide(i1, i2));
    }

    @Operation(
            summary = "Divides one imaginary number with one real number",
            description = """
            Receives one string that must represent a valid imaginary number
            and a real number.
            Due to algebraic properties, the result of the division will always
            be an imaginary number.
            """
    )
    @ApiResponse(responseCode = "200", description = "Division calculated successfully")
    @ApiResponse(responseCode = "400", description = "Null or invalid imaginary number")
    @ApiResponse(responseCode = "500", description = "Internal error")
    @PostMapping("/divide/imaginary/real")
    public ResponseEntity<String> divide(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "Required input to calculate the division",
                required = true,
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                implementation = BinaryImaginaryAndRealOperationInputDTO.class
                        )
                )
        )
        @RequestBody BinaryImaginaryAndRealOperationInputDTO input){
        ImaginaryNumber im = ImaginaryNumber.fromString(input.getInput());
        return ResponseEntity.ok(imaginaryService.divide(im, input.getRinput()).toString());
    }

    @Operation(
            summary = "Divides one real number with one imaginary number",
            description = """
            Receives one string that must represent a valid imaginary number
            and a real number.
            Due to algebraic properties, the result of the division will always
            be an imaginary number.
            """
    )
    @ApiResponse(responseCode = "200", description = "Division calculated successfully")
    @ApiResponse(responseCode = "400", description = "Null or invalid imaginary number")
    @ApiResponse(responseCode = "500", description = "Internal error")
    @PostMapping("/divide/real/imaginary")
    public ResponseEntity<String> divideRealWithImaginary(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Required input to calculate the division",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = BinaryImaginaryAndRealOperationInputDTO.class
                            )
                    )
            )
            @RequestBody BinaryImaginaryAndRealOperationInputDTO input){
        ImaginaryNumber im = ImaginaryNumber.fromString(input.getInput());
        return ResponseEntity.ok(imaginaryService.divide(input.getRinput(), im).toString());
    }

    @Operation(
            summary = "Obtains the sign of an imaginary number",
            description = """
                Receives a string that must represent an imaginary number.
                The result is 1 if the numeric coefficient of the imaginary
                number is positive or -1 if it's negative.
                """
    )
    @ApiResponse(responseCode = "200", description = "Sign obtained successfully")
    @ApiResponse(responseCode = "400", description = "Null or invalid imaginary input")
    @ApiResponse(responseCode = "500", description = "Internal error")
    @PostMapping("/sgn")
    public ResponseEntity<Double> sgn(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Required input to calculate the nrt",
            required = true,
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(
                    implementation = UnaryImaginaryOperationInputDTO.class
                )
            )
        )
        @RequestBody UnaryImaginaryOperationInputDTO input){
        ImaginaryNumber i = ImaginaryNumber.fromString(input.getInput());
        return ResponseEntity.ok(imaginaryService.sgn(i));
    }

    @Operation(
            summary = "Obtains the square root of a real number",
            description = """
                Receives a double via query string and calculates its
                square root. Unlike the sqrt method in JSE's Math class,
                this API returns an imaginary number if the input number
                is lower than zero instead of a NaN (Not a Number)
                """
    )
    @ApiResponse(responseCode = "200", description = "Sign obtained successfully")
    @ApiResponse(responseCode = "400", description = "Null or invalid input")
    @ApiResponse(responseCode = "500", description = "Internal error")
    @GetMapping("/sqrt")
    public ResponseEntity<String> sqrt(
        @Parameter(
                in = ParameterIn.QUERY,
                name = "ofNumber",
                description = "Real number whose square root will be calculated",
                example = "2",
                required = true
        )
        @RequestParam("ofNumber") double number){
        return ResponseEntity.ok(imaginaryService.sqrt(number).toString());
    }

    @Operation(
            summary = "Calculates the nth roots of an imaginary number",
            description = """
                Receives a string representing an imaginary number m and a
                non-zero integer from a request body to calculate the n roots
                of the imaginary number.
                The result is a list of n complex numbers. For each kth complex
                number in the list (with k between 0 and n - 1),
                its value is the result of raise the e constant (e = 2.71828...)
                to the power of exp, where exp is 2P(k + (s/4)) / n, where P is
                the PI constant (pi = 3.141592...) and s = sgn(m).
                """
    )
    @ApiResponse(responseCode = "200", description = "Roots calculated successfully")
    @ApiResponse(responseCode = "400", description = "Null or invalid imaginary input")
    @ApiResponse(responseCode = "500", description = "Internal error")
    @PostMapping("/nrt")
    public ResponseEntity<ComplexListOutputDTO> nrt(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Required input to calculate the nrt",
            required = true,
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(
                    implementation = BinaryImaginaryAndIntOperationInputDTO.class
                )
            )
        )
        @RequestBody BinaryImaginaryAndIntOperationInputDTO input){
        ImaginaryNumber in = ImaginaryNumber.fromString(input.getInput());
        List<String> res =
            imaginaryService.nrt(in, input.getIinput())
                            .stream()
                            .map(ComplexNumber::toString)
                            .toList();
        ComplexListOutputDTO out =
            ComplexListOutputDTO
                .builder()
                .result(res).build();
        return ResponseEntity.ok(out);
    }

    @Operation(
            summary = "Obtains the sine of an imaginary number",
            description = """
                Receives a string that must represent an imaginary number.
                The result is the sine of the the imaginary number represented
                by the string.
                """
    )
    @ApiResponse(responseCode = "200", description = "Sine calculated successfully")
    @ApiResponse(responseCode = "400", description = "Null or invalid imaginary input")
    @ApiResponse(responseCode = "500", description = "Internal error")
    @PostMapping("/sin")
    public ResponseEntity<String> sin(@RequestBody UnaryImaginaryOperationInputDTO input){
        ImaginaryNumber i = ImaginaryNumber.fromString(input.getInput());
        return ResponseEntity.ok(imaginaryService.sin(i).toString());
    }
}
