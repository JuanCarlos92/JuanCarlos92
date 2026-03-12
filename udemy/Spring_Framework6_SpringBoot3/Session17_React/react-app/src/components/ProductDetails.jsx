// Componente para mostrar los detalles de un producto
export const ProductDetails = ({ product }) => {
    return (
        <tr>
            <td>{product.name}</td>
            <td>{product.description}</td>
            <td>{product.price}</td>
        </tr>
    );
}