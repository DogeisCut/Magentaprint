package io.github.dogeiscut.magentaprint.content.entities.creative_creature;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

// TODO: look into QuadropedModel
public class CreativeCreatureModel<T extends CreativeCreatureEntity> extends AgeableListModel<T> {
    private final ModelPart head;
    private final ModelPart head_rotation;
    private final ModelPart ears_rotation;
    private final ModelPart body;
    private final ModelPart tail;
    private final ModelPart front_left_leg;
    private final ModelPart front_right_leg;
    private final ModelPart back_right_leg;
    private final ModelPart back_left_leg;

    public CreativeCreatureModel(ModelPart root) {
        this.head = root.getChild("head");
        this.head_rotation = this.head.getChild("head_rotation");
        this.ears_rotation = this.head_rotation.getChild("ears_rotation");
        this.body = root.getChild("body");
        this.tail = root.getChild("tail");
        this.front_left_leg = root.getChild("front_left_leg");
        this.front_right_leg = root.getChild("front_right_leg");
        this.back_right_leg = root.getChild("back_right_leg");
        this.back_left_leg = root.getChild("back_left_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 18.0F, -2.5F));

        PartDefinition head_rotation = head.addOrReplaceChild("head_rotation", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, -7.5F, 6.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

        PartDefinition ears_rotation = head_rotation.addOrReplaceChild("ears_rotation", CubeListBuilder.create().texOffs(26, 16).addBox(-2.5F, -2.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(26, 18).addBox(0.5F, -2.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 1.5F, -0.3927F, 0.0F, 0.0F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 12).addBox(-2.5F, -2.0F, -4.0F, 5.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 0.0F));

        PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(26, 12).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.0F, 4.0F));

        PartDefinition front_left_leg = partdefinition.addOrReplaceChild("front_left_leg", CubeListBuilder.create().texOffs(0, 24).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 21.0F, -3.0F));

        PartDefinition front_right_leg = partdefinition.addOrReplaceChild("front_right_leg", CubeListBuilder.create().texOffs(8, 24).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 21.0F, -3.0F));

        PartDefinition back_right_leg = partdefinition.addOrReplaceChild("back_right_leg", CubeListBuilder.create().texOffs(16, 24).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 21.0F, 3.0F));

        PartDefinition back_left_leg = partdefinition.addOrReplaceChild("back_left_leg", CubeListBuilder.create().texOffs(24, 24).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 21.0F, 3.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        front_left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        front_right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        back_right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        back_left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of(this.head, this.head_rotation, this.ears_rotation);
    }

    @Override
    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of(this.body, this.tail, this.front_left_leg, this.front_right_leg, this.back_right_leg, this.back_left_leg);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.yRot = netHeadYaw * ((float) Math.PI / 180F);
        this.head.xRot = headPitch * ((float) Math.PI / 180F);

        this.tail.xRot = 0.1F + 0.05F * Mth.cos(ageInTicks * 0.3F);

        this.front_left_leg.xRot = Mth.cos(limbSwing * 0.6662F * 2.0f) * 1.4F * limbSwingAmount;
        this.back_right_leg.xRot = Mth.cos(limbSwing * 0.6662F * 2.0f) * 1.4F * limbSwingAmount;
        this.front_right_leg.xRot = Mth.cos(limbSwing * 0.6662F * 2.0f + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.back_left_leg.xRot = Mth.cos(limbSwing * 0.6662F * 2.0f + (float) Math.PI) * 1.4F * limbSwingAmount;
    }
}