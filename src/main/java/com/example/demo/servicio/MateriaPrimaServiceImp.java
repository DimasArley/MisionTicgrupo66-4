package com.example.demo.servicio;

import com.example.demo.domain.MateriaPrima;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.dao.IMateriaPrimaDAO;

@Service
@Slf4j
public class MateriaPrimaServiceImp implements MateriaPrimaService{
    
    @Autowired
    private IMateriaPrimaDAO materiaPrimaDao;

    @Override
    @Transactional(readOnly = true)
    public List<MateriaPrima> listMateriaPrima() {
        return (List<MateriaPrima>) materiaPrimaDao.findAll();
    }

    @Override
    @Transactional
    public void saveMateriaPrima(MateriaPrima materiaPrima) {
        materiaPrima.setFechaCrea(new Date());
        materiaPrima.setUserCrea("DIMAS LOPEZ");
        materiaPrimaDao.save(materiaPrima);
        log.info("ingreso a guardar Materia prima");
    }

    @Override
    public void deleteMateriaPrima(MateriaPrima materiaPrima) {
        materiaPrimaDao.delete(materiaPrima);
    }

    @Override
    public MateriaPrima findMateriaPrima(MateriaPrima materiaPrima) {
        return materiaPrimaDao.findById(materiaPrima.getIdMateriaPrima()).orElse(materiaPrima);
    }
    
}
