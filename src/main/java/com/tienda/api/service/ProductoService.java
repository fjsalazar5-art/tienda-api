package com.tienda.api.service;

import com.tienda.api.exception.ProductoInvalidoException;
import com.tienda.api.exception.ProductoNoEncontradoException;
import com.tienda.api.model.Producto;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {

    private final List<Producto> productos = new ArrayList<>();
    private Long siguienteId = 1L;

    public ProductoService() {
        productos.add(new Producto(siguienteId++, "Laptop", 850.00, 10));
        productos.add(new Producto(siguienteId++, "Mouse", 15.50, 25));
        productos.add(new Producto(siguienteId++, "Teclado", 30.00, 15));
    }

    public List<Producto> listarProductos() {
        return productos;
    }

    public Producto obtenerProductoPorId(Long id) {
        return productos.stream()
                .filter(producto -> producto.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProductoNoEncontradoException(
                        "No existe un producto con el ID: " + id));
    }

    public Producto guardarProducto(Producto producto) {

        if (producto.getPrecio() <= 0) {
            throw new ProductoInvalidoException(
                    "El precio debe ser mayor que cero.");
        }

        if (producto.getStock() < 0) {
            throw new ProductoInvalidoException(
                    "El stock no puede ser negativo.");
        }

        producto.setId(siguienteId++);
        productos.add(producto);

        return producto;
    }

    public void eliminarProducto(Long id) {
        Producto producto = obtenerProductoPorId(id);
        productos.remove(producto);
    }
}