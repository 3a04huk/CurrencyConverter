package com.blabla.Abstract;

import com.blabla.ClientOperationDTO;

import java.util.ArrayList;

/**
 * Интерфейс. Функционала Источник данных
 */
public interface IDataSource {
    ArrayList<ClientOperationDTO> load();
}
