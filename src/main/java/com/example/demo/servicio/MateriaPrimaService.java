package com.example.demo.servicio;

import com.example.demo.domain.MateriaPrima;
import java.util.List;

public interface MateriaPrimaService {

    public List<MateriaPrima> listMateriaPrima();

    public void saveMateriaPrima(MateriaPrima materiaPrima);

    public void deleteMateriaPrima(MateriaPrima materiaPrima);

    public MateriaPrima findMateriaPrima(MateriaPrima materiaPrima);

}
