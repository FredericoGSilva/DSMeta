import img from '../../assets/img/logo.svg';
import './styles.css';

function Header() {
    return (
        <header>
            <div className="dsmeta-logo-container">
                <img src={img} alt="DSMeta" />
                <h1>DSMeta</h1>
                <p>Desenvolvido por
                    <a href="https://www.linkedin.com/in/frederico-guilherme-460585225/"> Frederico G. Silva</a>
                </p>
            </div>
        </header>
    )
}

export default Header;