package br.gov.sc.ciasc.webnuc.api.controller;

import br.gov.sc.ciasc.webnuc.api.WebnucApplication;
import br.gov.sc.ciasc.webnuc.api.dto.UnidadeMedidaDTO;
import br.gov.sc.ciasc.webnuc.api.service.UnidadeMedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = WebnucApplication.API_ENDPOINT,
                produces = MediaType.APPLICATION_JSON_VALUE)
public class UnidadeMedidaController {

    public static final String ENDPOINT = "unidadesmedida";

    @Autowired
    private UnidadeMedidaService unidadeMedidaService;

    //@RequestMapping(value = ENDPOINT, method = RequestMethod.GET, params = {"sort", "offset", "max"})
    @GetMapping(value = ENDPOINT)
    @ResponseBody
    public List<UnidadeMedidaDTO> findAll(@RequestParam(value = "sort", required = false) String sort,
                                          @RequestParam(value = "max", required = false) Integer max,
                                          @RequestParam(value = "offset", required = false) Integer offset) {

        System.out.println("===== params: sort [" + sort + "]");

        //
        // TODO resolver a questão do check NULL
        //
        Optional<String> sortBy = Optional.ofNullable(sort);
        System.out.println("===== params: sortBy [" + sortBy + "]");

        return unidadeMedidaService.findAll(new Sort(Sort.Direction.ASC, "codigo"));
    }
}
