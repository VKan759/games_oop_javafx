package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class BishopBlackTest {

    @Test
    void position() {
        Figure bishopBlack = new BishopBlack(Cell.H3);
        assertThat(bishopBlack.position()).isEqualByComparingTo(Cell.H3);

    }

    @Test
    void copy() {
        Figure bishopBlack = new BishopBlack(Cell.A1);
        Figure copy = bishopBlack.copy(Cell.G5);
        assertThat(copy.position()).isEqualByComparingTo(Cell.G5);
    }


    @Test
    void wayIsAvailable() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(bishopBlack.way(Cell.G5)).isEqualTo(result);
    }

    @Test
    void wayIsError() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell dest = Cell.G4;
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    bishopBlack.way(dest);
                }
        );
        assertThat(exception.getMessage()).isEqualTo("Could not way by diagonal from C1 to G4");
    }
}
