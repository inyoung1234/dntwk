package com.dntwk.comm;

import com.dntwk.directory.DTO.CreateDirectoryDTO;
import org.junit.jupiter.api.Test;



public class DTOToEntityTest {
    @Test
    public void test(){
        CreateDirectoryDTO createDirectoryDTO = new CreateDirectoryDTO();

        System.out.println(createDirectoryDTO.getTarget().getClass());
    }
}
