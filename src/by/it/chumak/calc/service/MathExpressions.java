package by.it.chumak.calc.service;

import by.it.chumak.calc.exception.CalcException;
import by.it.chumak.calc.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class MathExpressions implements Operation {

    @Override
    public Var add(ResourceManager resourceManager, LoggerMethods logger, SetReportBuilder reportBuilder, List<ReportBuilder> builders, Var varLeftPartExpression, Var varRightPartExpression) throws CalcException {
        ArrayList<Object> values = Assistants.getValues(varLeftPartExpression, varRightPartExpression);
        String leftPartExpression = varLeftPartExpression.toString();
        String rightPartExpression = varRightPartExpression.toString();


        if (values != null) {

            if (varLeftPartExpression.getClass().getSimpleName().equals(varRightPartExpression.getClass().getSimpleName())) {
                if (varLeftPartExpression instanceof Scalar) {
                    return new Scalar((double) values.get(0) + (double) values.get(1), leftPartExpression, rightPartExpression);
                } else if (varLeftPartExpression instanceof Vector) {
                    return getVectorAddVector(resourceManager, logger, reportBuilder, builders, (double[]) values.get(0), (double[]) values.get(1), leftPartExpression, rightPartExpression);
                } else if (varLeftPartExpression instanceof Matrix) {
                    return getMatrixAddMatrix(resourceManager, logger, reportBuilder, builders, (double[][]) values.get(0), (double[][]) values.get(1), leftPartExpression, rightPartExpression);
                }
            } else {
                if (varLeftPartExpression instanceof Scalar && varRightPartExpression instanceof Vector) {
                    return getVectorAddScalar((double) values.get(0), (double[]) values.get(1), leftPartExpression, rightPartExpression);
                } else if (varLeftPartExpression instanceof Vector && varRightPartExpression instanceof Scalar) {
                    return getVectorAddScalar((double) values.get(1), (double[]) values.get(0), rightPartExpression, leftPartExpression);
                } else if (varLeftPartExpression instanceof Scalar && varRightPartExpression instanceof Matrix) {
                    return getMatrixAddScalar((double) values.get(0), (double[][]) values.get(1), leftPartExpression, rightPartExpression);
                } else if (varLeftPartExpression instanceof Matrix && varRightPartExpression instanceof Scalar) {
                    return getMatrixAddScalar((double) values.get(1), (double[][]) values.get(0), rightPartExpression, leftPartExpression);
                }
            }
        }
        throw new CalcException(logger, reportBuilder, builders, resourceManager, String.format("%s, %s + %s%n", resourceManager.get(Messages.INCORRECT_OPERATION), varLeftPartExpression, varRightPartExpression));
    }

    @Override
    public Var sub(ResourceManager resourceManager, LoggerMethods logger, SetReportBuilder reportBuilder, List<ReportBuilder> builders, Var varLeftPartExpression, Var varRightPartExpression) throws CalcException {
        ArrayList<Object> values = Assistants.getValues(varLeftPartExpression, varRightPartExpression);
        String leftPartExpression = varLeftPartExpression.toString();
        String rightPartExpression = varRightPartExpression.toString();

        if (values != null) {

            if (varLeftPartExpression.getClass().getSimpleName().equals(varRightPartExpression.getClass().getSimpleName())) {
                if (varLeftPartExpression instanceof Scalar) {
                    return new Scalar((double) values.get(0) - (double) values.get(1), leftPartExpression, rightPartExpression);
                } else if (varLeftPartExpression instanceof Vector) {
                    return getVectorSubVector(resourceManager, logger, reportBuilder, builders, (double[]) values.get(0), (double[]) values.get(1), leftPartExpression, rightPartExpression);
                } else if (varLeftPartExpression instanceof Matrix) {
                    return getMatrixSubMatrix(resourceManager, logger, reportBuilder, builders, (double[][]) values.get(0), (double[][]) values.get(1), leftPartExpression, rightPartExpression);
                }
            } else {
                if (varLeftPartExpression instanceof Scalar && varRightPartExpression instanceof Vector) {
                    return getVectorSubScalar((double) values.get(0), (double[]) values.get(1), leftPartExpression, rightPartExpression);
                } else if (varLeftPartExpression instanceof Vector && varRightPartExpression instanceof Scalar) {
                    return getVectorSubScalar((double) values.get(1), (double[]) values.get(0), rightPartExpression, leftPartExpression);
                } else if (varLeftPartExpression instanceof Scalar && varRightPartExpression instanceof Matrix) {
                    return getMatrixSubScalar((double) values.get(0), (double[][]) values.get(1), leftPartExpression, rightPartExpression);
                } else if (varLeftPartExpression instanceof Matrix && varRightPartExpression instanceof Scalar) {
                    return getMatrixSubScalar((double) values.get(1), (double[][]) values.get(0), rightPartExpression, leftPartExpression);
                }
            }
        }
        throw new CalcException(logger, reportBuilder, builders, resourceManager, String.format("%s, %s - %s%n", resourceManager.get(Messages.INCORRECT_OPERATION), varLeftPartExpression, varRightPartExpression));
    }

    @Override
    public Var mul(ResourceManager resourceManager, LoggerMethods logger, SetReportBuilder reportBuilder, List<ReportBuilder> builders, Var varLeftPartExpression, Var varRightPartExpression) throws CalcException {
        ArrayList<Object> values = Assistants.getValues(varLeftPartExpression, varRightPartExpression);
        String leftPartExpression = varLeftPartExpression.toString();
        String rightPartExpression = varRightPartExpression.toString();

        if (values != null) {

            if (varLeftPartExpression.getClass().getSimpleName().equals(varRightPartExpression.getClass().getSimpleName())) {
                if (varLeftPartExpression instanceof Scalar) {
                    return new Scalar((double) values.get(0) * (double) values.get(1), leftPartExpression, rightPartExpression);
                } else if (varLeftPartExpression instanceof Vector) {
                    return getVectorMulVector(resourceManager, logger, reportBuilder, builders, (double[]) values.get(0), (double[]) values.get(1), leftPartExpression, rightPartExpression);
                } else if (varLeftPartExpression instanceof Matrix) {
                    return getMatrixMulMatrix(resourceManager, logger, reportBuilder, builders, (double[][]) values.get(0), (double[][]) values.get(1), leftPartExpression, rightPartExpression);
                }
            } else {
                if (varLeftPartExpression instanceof Scalar && varRightPartExpression instanceof Vector) {
                    return getVectorMulScalar((double) values.get(0), (double[]) values.get(1), leftPartExpression, rightPartExpression);
                } else if (varLeftPartExpression instanceof Vector && varRightPartExpression instanceof Scalar) {
                    return getVectorMulScalar((double) values.get(1), (double[]) values.get(0), rightPartExpression, leftPartExpression);
                } else if (varLeftPartExpression instanceof Scalar && varRightPartExpression instanceof Matrix) {
                    return getMatrixMulScalar((double) values.get(0), (double[][]) values.get(1), leftPartExpression, rightPartExpression);
                } else if (varLeftPartExpression instanceof Matrix && varRightPartExpression instanceof Scalar) {
                    return getMatrixMulScalar((double) values.get(1), (double[][]) values.get(0), rightPartExpression, leftPartExpression);
                } else if (varLeftPartExpression instanceof Vector && varRightPartExpression instanceof Matrix) {
                    return getVectorMulMatrix(resourceManager, logger, reportBuilder, builders, (double[]) values.get(0), (double[][]) values.get(1), leftPartExpression, rightPartExpression);
                } else if (varLeftPartExpression instanceof Matrix && varRightPartExpression instanceof Vector) {
                    return getVectorMulMatrix(resourceManager, logger, reportBuilder, builders, (double[]) values.get(1), (double[][]) values.get(0), rightPartExpression, leftPartExpression);
                }
            }
        }
        throw new CalcException(logger, reportBuilder, builders, resourceManager, String.format("%s, %s * %s%n", resourceManager.get(Messages.INCORRECT_OPERATION), varLeftPartExpression, varRightPartExpression));
    }

    @Override
    public Var div(ResourceManager resourceManager, LoggerMethods logger, SetReportBuilder reportBuilder, List<ReportBuilder> builders, Var varLeftPartExpression, Var varRightPartExpression) throws CalcException {
        ArrayList<Object> values = Assistants.getValues(varLeftPartExpression, varRightPartExpression);
        String leftPartExpression = varLeftPartExpression.toString();
        String rightPartExpression = varRightPartExpression.toString();

        if (values != null) {
            if (varLeftPartExpression.getClass().getSimpleName().equals(varRightPartExpression.getClass().getSimpleName())) {
                if (varLeftPartExpression instanceof Scalar) {
                    double doubleValue = (double) values.get(0) / (double) values.get(1);
                    if (Double.isInfinite(doubleValue) || Double.isNaN(doubleValue)) {
                        throw new CalcException(logger, reportBuilder, builders, resourceManager, resourceManager.get(Messages.INCORRECT_OPERATION_BY_ZERO) + "\n");
                    } else {
                        return new Scalar(doubleValue, leftPartExpression, rightPartExpression);
                    }
                }
            } else {
                if (varLeftPartExpression instanceof Scalar && varRightPartExpression instanceof Vector) {
                    throw new CalcException(logger, reportBuilder, builders, resourceManager, String.format("%s, %s / %s%n", resourceManager.get(Messages.INCORRECT_OPERATION), varLeftPartExpression, varRightPartExpression));
                } else if (varLeftPartExpression instanceof Vector && varRightPartExpression instanceof Scalar) {
                    return getVectorDivScalar(resourceManager, logger, reportBuilder, builders, (double) values.get(1), (double[]) values.get(0), rightPartExpression, leftPartExpression);
                } else if (varLeftPartExpression instanceof Scalar && varRightPartExpression instanceof Matrix) {
                    return getMatrixDivScalar(resourceManager, logger, reportBuilder, builders, (double) values.get(0), (double[][]) values.get(1), leftPartExpression, rightPartExpression);
                } else if (varLeftPartExpression instanceof Matrix && varRightPartExpression instanceof Scalar) {
                    return getMatrixDivScalar(resourceManager, logger, reportBuilder, builders, (double) values.get(1), (double[][]) values.get(0), rightPartExpression, leftPartExpression);
                }
            }
        }
        throw new CalcException(logger, reportBuilder, builders, resourceManager, String.format("%s, %s / %s%n", resourceManager.get(Messages.INCORRECT_OPERATION), varLeftPartExpression, varRightPartExpression));
    }

    private Var getMatrixSubScalar(double a, double[][] b, String leftPartExpression, String rightPartExpression) {
        double[][] result = new double[b.length][b[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = b[i][j] - a;
            }
        }
        return new Matrix(result);
    }

    private Var getVectorSubScalar(double a, double[] b, String leftPartExpression, String rightPartExpression) {
        double[] result = new double[b.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = b[i] - a;
        }
        return new Vector(result);
    }

    private Var getMatrixSubMatrix(ResourceManager resourceManager, LoggerMethods logger, SetReportBuilder reportBuilder, List<ReportBuilder> builders, double[][] a, double[][] b, String leftPartExpression, String rightPartExpression) throws CalcException {
        double[][] result = new double[a.length][a[0].length];

        if (result.length != b[0].length) {
            throw new CalcException(logger, reportBuilder, builders, resourceManager, String.format("%s %s - %s%n", resourceManager.get(Messages.INCORRECT_OPERATION), leftPartExpression, rightPartExpression));
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }
        return new Matrix(result);
    }

    private Var getVectorSubVector(ResourceManager resourceManager, LoggerMethods logger, SetReportBuilder reportBuilder, List<ReportBuilder> builders, double[] a, double[] b, String leftPartExpression, String rightPartExpression) throws CalcException {
        double[] result = new double[a.length];

        if (result.length != b.length) {
            throw new CalcException(logger, reportBuilder, builders, resourceManager, String.format("%s %s - %s%n", resourceManager.get(Messages.INCORRECT_OPERATION), leftPartExpression, rightPartExpression));
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = a[i] - b[i];
        }
        return new Vector(result);
    }

    private Var getVectorMulMatrix(ResourceManager resourceManager, LoggerMethods logger, SetReportBuilder reportBuilder, List<ReportBuilder> builders, double[] a, double[][] b, String leftPartExpression, String rightPartExpression) throws CalcException {
        double[] result = new double[a.length];
        int verticalVectorSize = b[0].length;
        int horizontalVectorSize = a.length;

        if (verticalVectorSize != horizontalVectorSize) {
            throw new CalcException(logger, reportBuilder, builders, resourceManager, String.format("%s %s * %s%n", resourceManager.get(Messages.INCORRECT_OPERATION), leftPartExpression, rightPartExpression));
        }
        for (int i = 0; i < horizontalVectorSize; i++) {
            for (int j = 0; j < result.length; j++) {
                result[i] = result[i] + (b[i][j]) * (a[j]);
            }
        }
        return new Vector(result);

    }

    private Var getMatrixMulScalar(double a, double[][] b, String leftPartExpression, String rightPartExpression) {
        double[][] result = new double[b.length][b[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = b[i][j] * a;
            }
        }
        return new Matrix(result);
    }

    private Var getVectorMulScalar(double a, double[] b, String leftPartExpression, String rightPartExpression) {
        double[] result = new double[b.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = b[i] * a;
        }
        return new Vector(result);
    }

    private Var getMatrixMulMatrix(ResourceManager resourceManager, LoggerMethods logger, SetReportBuilder reportBuilder, List<ReportBuilder> builders, double[][] a, double[][] b, String leftPartExpression, String rightPartExpression) throws CalcException {
        double[][] result = new double[a.length][a[0].length];
        int verticalMatrixSize = a[0].length;
        int horizontalMatrixSize = b.length;

        if (verticalMatrixSize != horizontalMatrixSize) {
            throw new CalcException(logger, reportBuilder, builders, resourceManager, String.format("%s %s * %s%n", resourceManager.get(Messages.INCORRECT_OPERATION), leftPartExpression, rightPartExpression));
        }

        for (int i = 0; i < verticalMatrixSize; i++) {
            for (int j = 0; j < horizontalMatrixSize; j++) {
                for (int k = 0; k < result.length; k++) {
                    result[i][j] = result[i][j] + (a[i][k]) * (b[k][j]);
                }
            }
        }
        return new Matrix(result);
    }

    private Var getVectorMulVector(ResourceManager resourceManager, LoggerMethods logger, SetReportBuilder reportBuilder, List<ReportBuilder> builders, double[] a, double[] b, String leftPartExpression, String rightPartExpression) throws CalcException {
        double[] result = new double[1];

        if (a.length != b.length) {
            throw new CalcException(logger, reportBuilder, builders, resourceManager, String.format("%s %s * %s%n", resourceManager.get(Messages.INCORRECT_OPERATION), leftPartExpression, rightPartExpression));
        }
        for (int i = 0; i < a.length; i++) {
            result[0] = result[0] + (a[i] * b[i]);
        }
        return new Vector(result);
    }

    private Var getMatrixDivScalar(ResourceManager resourceManager, LoggerMethods logger, SetReportBuilder reportBuilder, List<ReportBuilder> builders, double a, double[][] b, String leftPartExpression, String rightPartExpression) throws CalcException {
        if (Double.isNaN(a) || Double.isInfinite(a) || a == 0) {
            throw new CalcException(logger, reportBuilder, builders, resourceManager, resourceManager.get(Messages.INCORRECT_OPERATION_BY_ZERO) + "\n");
        }
        double[][] result = Arrays.copyOf(b, b.length);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = result[i][j] / a;
            }
        }
        return new Matrix(result);
    }

    private Var getVectorDivScalar(ResourceManager resourceManager, LoggerMethods logger, SetReportBuilder reportBuilder, List<ReportBuilder> builders, double a, double[] b, String rightPartExpression, String leftPartExpression) throws CalcException {
        if (Double.isNaN(a) || Double.isInfinite(a) || a == 0) {
            throw new CalcException(logger, reportBuilder, builders, resourceManager, resourceManager.get(Messages.INCORRECT_OPERATION_BY_ZERO) + "\n");
        }
        double[] result = new double[b.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = b[i] / a;
        }
        return new Vector(result);
    }

    private Var getMatrixAddMatrix(ResourceManager resourceManager, LoggerMethods logger, SetReportBuilder reportBuilder, List<ReportBuilder> builders, double[][] a, double[][] b, String leftPartExpression, String rightPartExpression) throws CalcException {
        double[][] result = new double[a.length][a[0].length];

        if (result.length != b.length) {
            throw new CalcException(logger, reportBuilder, builders, resourceManager, String.format("%s %s + %s%n", resourceManager.get(Messages.INCORRECT_OPERATION), leftPartExpression, rightPartExpression));
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return new Matrix(result);
    }

    private Var getMatrixAddScalar(double a, double[][] b, String leftPartExpression, String rightPartExpression) {
        double[][] result = new double[b.length][b[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = b[i][j] + a;
            }
        }
        return new Matrix(result);
    }

    private Vector getVectorAddVector(ResourceManager resourceManager, LoggerMethods logger, SetReportBuilder reportBuilder, List<ReportBuilder> builders, double[] a, double[] b, String leftPartExpression, String rightPartExpression) throws CalcException {
        double[] result = new double[a.length];

        if (result.length != b.length) {
            throw new CalcException(logger, reportBuilder, builders, resourceManager, String.format("%s %s + %s%n", resourceManager.get(Messages.INCORRECT_OPERATION), leftPartExpression, rightPartExpression));
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = a[i] + b[i];
        }
        return new Vector(result);
    }

    private Vector getVectorAddScalar(double a, double[] b, String leftPartExpression, String rightPartExpression) {
        double[] result = new double[b.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = b[i] + a;
        }
        return new Vector(result);
    }
}
