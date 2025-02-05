package es.ies.puerto.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.ies.puerto.api.dto.RolDto;
import es.ies.puerto.controller.RolController;
import es.ies.puerto.model.entity.Rol;
import es.ies.puerto.model.repository.IRolRepository;

public class RolControllerTest {

    @InjectMocks
    private RolController rolController;

    @Mock
    private IRolRepository rolRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAllTest() {
        List<Rol> roles = new ArrayList<>();
        Rol rol = new Rol();
        rol.setId(2);
        roles.add(rol);
        when(rolRepository.findAll()).thenReturn(roles);
        List<RolDto> rolDtos = rolController.findAll();
        assertNotNull(rolDtos);
        assertEquals(1, rolDtos.size());
    }

    @Test
    void findByIdFoundTest() {
        Rol rol = new Rol();
        rol.setId(2);
        when(rolRepository.findById(2)).thenReturn(Optional.of(rol));
        RolDto rolDto = rolController.findById(2);
        assertNotNull(rolDto);
    }

    @Test
    void findByIdNotFoundTest() {
        when(rolRepository.findById(anyInt())).thenReturn(Optional.empty());
        RolDto rolDto = rolController.findById(10);
        assertNotNull(rolDto);
    }

    @Test
    void saveTest() {
        RolDto inputDto = new RolDto();
        inputDto.setId(3);
        Rol rol = new Rol();
        rol.setId(3);
        when(rolRepository.save(any(Rol.class))).thenReturn(rol);
        RolDto savedDto = rolController.save(inputDto);
        assertNotNull(savedDto);
        assertEquals(3, savedDto.getId());
    }

    @Test
    void updateTest() {
        RolDto inputDto = new RolDto();
        inputDto.setId(4);
        Rol rol = new Rol();
        rol.setId(4);
        when(rolRepository.save(any(Rol.class))).thenReturn(rol);
        RolDto updatedDto = rolController.update(inputDto);
        assertNotNull(updatedDto);
        assertEquals(4, updatedDto.getId());
    }

    @Test
    void deleteByIdValidTest() {
        int id = 2;
        doNothing().when(rolRepository).changeToUser(id);
        doNothing().when(rolRepository).deleteById(id);
        rolController.deleteById(id);
        verify(rolRepository).changeToUser(id);
        verify(rolRepository).deleteById(id);
    }

    @Test
    void deleteByIdInvalidTest() {
        assertThrows(IllegalArgumentException.class, () -> rolController.deleteById(1));
        assertThrows(IllegalArgumentException.class, () -> rolController.deleteById(5));
    }
}
