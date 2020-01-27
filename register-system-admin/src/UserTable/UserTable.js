import React from "react";
import './UserTable.css';
import axios from 'axios';

export default class UserTable extends React.Component {
    state = {
        users: []
    };

    componentDidMount() {
        this.fetchUsers();
    }

    fetchUsers() {
        axios.get('http://localhost:8080/users')
            .then(res => {
                console.table(res.data);
                const fetchedUsers = res.data;
                this.setState({
                    users: fetchedUsers
                });
            }).catch(
            reason => {
                console.log(reason);
            }
        );
    }

    sendDeleteUsername(username) {
        axios.delete('http://localhost:8080/user/' + username)
            .then(res => {
                    console.log(res.status);
                    this.fetchUsers();
                }
            )
    }

    renderAllUsers() {
        return this.state.users.map((u) => {
            return (
                <tr key={u.id}>
                    <td>{u.id}</td>
                    <td>{u.username}</td>
                    <td><button onClick={(e) => this.sendDeleteUsername(u.username)}>Delete</button></td>
                </tr>
            );
        });
    }

    render() {
        return (
            <div class="UserTable">
                <table>
                    <tbody>
                    {this.renderAllUsers()}
                    </tbody>
                </table>
            </div>
        );
    }
}