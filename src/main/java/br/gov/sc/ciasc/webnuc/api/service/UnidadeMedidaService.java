package br.gov.sc.ciasc.webnuc.api.service;

import br.gov.sc.ciasc.webnuc.api.domain.UnidadeMedida;
import br.gov.sc.ciasc.webnuc.api.dto.UnidadeMedidaDTO;
import br.gov.sc.ciasc.webnuc.api.repository.UnidadeMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class UnidadeMedidaService {

    @Autowired
    private UnidadeMedidaRepository unidadeMedidaRepository;

    public List<UnidadeMedidaDTO> findAll() {

        return unidadeMedidaRepository.findAll().stream()
                .map(entity -> new UnidadeMedidaDTO(
                        entity.getId(),
                        entity.getCodigo(),
                        entity.getNome(),
                        entity.getSigla()))
                .collect(Collectors.toList());
    }

    public List<UnidadeMedidaDTO> findAll(Sort sort) {

        TestarDataDeAtualizacao();

        return unidadeMedidaRepository.findAll(sort).stream()
                .map(entity -> new UnidadeMedidaDTO(
                        entity.getId(),
                        entity.getCodigo(),
                        entity.getNome(),
                        entity.getSigla()))
                .collect(Collectors.toList());
    }


    private void TestarDataDeAtualizacao() {
        UnidadeMedida unidadeMedida = unidadeMedidaRepository.findOne(1L);

        System.out.println("===== unidadeMedida: antes do save");
        System.out.println("===== unidadeMedida: data_cadastro [" + unidadeMedida.getDataCadastro() + "]");
        System.out.println("===== unidadeMedida: data_atualizacao [" + unidadeMedida.getDataAtualizacao() + "]");

        try {
            TimeUnit.SECONDS.sleep(2);
        }
        catch (InterruptedException ie) {
            System.out.println("===== InterruptedException: " + ie.getStackTrace().toString());
        }

        byte[] array = new byte[5]; // length is bounded by 5
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));

        unidadeMedida.setSigla(generatedString);
        unidadeMedidaRepository.save(unidadeMedida);

        System.out.println("===== unidadeMedida: depois do save");
        System.out.println("===== unidadeMedida: data_cadastro [" + unidadeMedida.getDataCadastro() + "]");
        System.out.println("===== unidadeMedida: data_atualizacao [" + unidadeMedida.getDataAtualizacao() + "]");
    }
}
