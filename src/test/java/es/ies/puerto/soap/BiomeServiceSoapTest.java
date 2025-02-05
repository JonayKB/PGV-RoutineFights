package es.ies.puerto.soap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.ies.puerto.api.dto.BiomeDto;
import es.ies.puerto.controller.BiomeController;
import es.ies.puerto.soap.service.BiomeServiceSoapImpl;

public class BiomeServiceSoapTest {

    @Mock
    private BiomeController biomeController;

    @InjectMocks
    private BiomeServiceSoapImpl biomeService;

    private BiomeDto sampleBiome;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sampleBiome = new BiomeDto();
        sampleBiome.setId(1);
        sampleBiome.setName("Forest");
    }

    @Test
    void getAll_ShouldReturnListOfBiomes() {
        List<BiomeDto> expectedBiomes = Arrays.asList(sampleBiome);
        when(biomeController.findAll()).thenReturn(expectedBiomes);

        List<BiomeDto> actualBiomes = biomeService.getAll();

        assertEquals(expectedBiomes, actualBiomes);
        verify(biomeController).findAll();
    }

    @Test
    void getById_WithExistingId_ShouldReturnBiome() {
        when(biomeController.findById(1)).thenReturn(sampleBiome);

        BiomeDto result = biomeService.getById(1);

        assertEquals(sampleBiome, result);
        verify(biomeController).findById(1);
    }

    @Test
    void getById_WithNonExistingId_ShouldReturnNull() {
        when(biomeController.findById(99)).thenReturn(null);

        BiomeDto result = biomeService.getById(99);

        assertNull(result);
        verify(biomeController).findById(99);
    }

    @Test
    void deleteById_WithExistingId_ShouldReturnTrue() {
        doNothing().when(biomeController).deleteById(1);

        Boolean result = biomeService.deleteById(1);

        assertTrue(result);
        verify(biomeController).deleteById(1);
    }

    @Test
    void deleteById_WithNonExistingId_ShouldReturnFalse() {
        doThrow(new RuntimeException("Biome not found")).when(biomeController).deleteById(99);

        Boolean result = biomeService.deleteById(99);

        assertFalse(result);
        verify(biomeController).deleteById(99);
    }

    @Test
    void create_ShouldReturnSavedBiome() {
        when(biomeController.save(sampleBiome)).thenReturn(sampleBiome);

        BiomeDto result = biomeService.create(sampleBiome);

        assertEquals(sampleBiome, result);
        verify(biomeController).save(sampleBiome);
    }

    @Test
    void create_WhenControllerThrowsException_ShouldPropagate() {
        when(biomeController.save(sampleBiome)).thenThrow(new RuntimeException("Error saving"));

        assertThrows(RuntimeException.class, () -> biomeService.create(sampleBiome));

        verify(biomeController).save(sampleBiome);
    }
}
