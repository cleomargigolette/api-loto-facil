package com.bi.lotofacil.service;

import com.bi.lotofacil.modail.Ball;
import com.bi.lotofacil.modail.Sweepstakes;
import lombok.Cleanup;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ManagerFileService {

    @Autowired
    private BallService ballService;

    @Autowired
    private SweepsyakesService sweepsyakesService;

    public List<Sweepstakes> createSweepstakes() throws IOException {

        this.ballService.createBall();
        List<Sweepstakes> sweepstakesList = new ArrayList<>();
        @Cleanup
        FileInputStream file = new FileInputStream("src/main/resources/lotofacil.xlsx");

        Workbook workbook = new XSSFWorkbook(file);

        Sheet sheet = workbook.getSheetAt(0);

        List<Row> rows = (List<Row>) toList(sheet.iterator());

        rows.forEach(row -> {
            List<Cell> cells = (List<Cell>) toList(row.cellIterator());

            List<Ball> listBalls = new ArrayList<>();

            System.out.println(cells.size());

            if (cells.size() > 0) {
                for (int i = 2; i < cells.size(); i++) {
                    Long id = new Long((int) cells.get(i).getNumericCellValue());
                    listBalls.add(ballService.findById(id));
                }
                int concurso = (int) cells.get(0).getNumericCellValue();
                Sweepstakes sweepstake = Sweepstakes.builder()
                        .concurso(concurso)
                        .date(cells.get(1).getDateCellValue())
                        .balls(listBalls)
                        .build();
                sweepstakesList.add(sweepstake);
            }
        });
        return sweepstakesList;
    }

    private List<?> toList(Iterator<?> iterator) {
        return IteratorUtils.toList(iterator);
    }
}
