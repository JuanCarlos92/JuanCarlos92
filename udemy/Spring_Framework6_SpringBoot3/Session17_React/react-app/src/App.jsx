import { useState } from 'react'
import './App.css'

// Componente principal de la aplicación
export const App = () => {
  const [count, setCount] = useState(0)

  // Función para manejar el evento de clic en el botón
  return (
    <>
      <h1>Vite + React</h1>
      <div className="card">
        <button onClick={() => setCount((count) => count + 1)}>
          el contador es {count}
        </button>
      </div>
    </>
  )
}

export default App
