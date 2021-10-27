import { Entity, Column, PrimaryGeneratedColumn } from "typeorm";

@Entity()
export class Classroom {
    @PrimaryGeneratedColumn()
    id: number;

    @Column()
    no: string;

    @Column()
    name: string;

    @Column()
    user_num: number;

    @Column()
    created_at: number;

    @Column()
    updated_at: number;
}
