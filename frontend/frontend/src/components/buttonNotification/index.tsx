import img from '../../assets/img/buttonNotification.svg';
import './styles.css';


function Button() {
    return (
        <div className="dsmeta-button">
            <img src={img} alt="Notificar" />
        </div>
    )
}

export default Button;