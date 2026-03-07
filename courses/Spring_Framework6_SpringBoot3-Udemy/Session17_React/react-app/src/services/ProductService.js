// Simulamos una base de datos con un array de productos
const iniProducts = [
    {
        name: "Monitor Samsung 24",
        price: 500,
        description: "Monitor de 24 pulgadas",
    },
    {
        name: "telefono xiaomi",
        price: 200,
        description: "telefono movil",
    }
]

// Función para listar los productos
export const listProducts = () => {
    return iniProducts
}